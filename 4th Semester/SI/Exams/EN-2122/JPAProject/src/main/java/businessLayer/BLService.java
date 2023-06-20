package businessLayer;

import java.sql.*;
import java.util.List;

import jakarta.persistence.*;
import dataAcessLayer.*;


public class BLService {
    private final EntityManager em;

    public BLService(EntityManager em) {
        this.em = em;
    }

    private void getBusinessTransaction(){
        em.getTransaction().begin();
    }

    private Connection getConnection(){
        em.getTransaction().begin();
        return em.unwrap(Connection.class);
    }

    private void commitBusinessTransaction(){
        em.getTransaction().commit();
    }

    private void rollbackBusinessTransaction(){
        em.getTransaction().rollback();
    }

    public Integer totalPontosJogador(Integer idJogador) {
        try {
            StoredProcedureQuery q = em.createStoredProcedureQuery("totalPontosJogador");
            q.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            q.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
            q.setParameter(1, idJogador);
            q.execute();
            return (Integer) q.getOutputParameterValue(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Integer totalJogosJogador(Integer idJogador) {
        try {
            StoredProcedureQuery q = em.createStoredProcedureQuery("totalJogosJogador");
            q.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            q.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
            q.setParameter(1, idJogador);
            q.execute();
            return (Integer) q.getOutputParameterValue(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Object[]> pontosJogoPorJogador(String refJogo) {
        try {
            StoredProcedureQuery q = em.createStoredProcedureQuery("PontosJogoPorJogador");
            q.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            q.setParameter(1, refJogo);
            q.execute();
            return (List<Object[]>) q.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Integer totalPartidasJogador(Integer idJogador) {
        try {
            StoredProcedureQuery q = em.createStoredProcedureQuery("totalPartidasJogador");
            q.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            q.registerStoredProcedureParameter( 2, Integer.class, ParameterMode.OUT);
            q.setParameter(1, idJogador);
            q.execute();
            return (Integer) q.getOutputParameterValue(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Integer criarJogador(String username, String email, String região) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call criarJogadorLógica(?,?,?,?)")) {
            f.registerOutParameter(1, Types.INTEGER);
            f.setString(2, username);
            f.setString(3, email);
            f.setString(4, região);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
            return f.getInt(1);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public void mudarEstadoJogador(Integer idJogador, String estadoJogador) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call mudarEstadoJogadorLógica(?,?)")) {
            f.setInt(1, idJogador);
            f.setString(2, estadoJogador);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public void associarCracha(Integer idJogador, String refJogo, String nomeCracha) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call associarCrachaLógica(?,?,?)")) {
            f.setInt(1, idJogador);
            f.setString(2, refJogo);
            f.setString(3, nomeCracha);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public void associarCrachaLocal(Integer idJogador, String refJogo, String nomeCracha) {
        try {
            getBusinessTransaction();
            Cracha cracha = em.find(Cracha.class, new Cracha.CrachaId(nomeCracha, refJogo));
            Integer limitePontos = cracha.getLimitePontos();

            Query partidaQuery = em.createQuery(
                    "SELECT p.id.num FROM Partida p WHERE p.id.idJogador = :id AND p.jogo.ref = :ref"
            );
            partidaQuery.setParameter("id", idJogador);
            partidaQuery.setParameter("ref", refJogo);
            Integer numPartida = (Integer) partidaQuery.getSingleResult();

            Query pontuacaoPMJQuery = em.createQuery(
                    """
                    SELECT p.pontuacao FROM Partida_Multi_Jogador p
                    WHERE p.partida.id.idJogador = :idJogador AND p.partida.id.num = :numPartida
                    AND p.estado = 'Terminada' ORDER BY p.pontuacao DESC
                    """
            );
            pontuacaoPMJQuery.setParameter("idJogador", idJogador);
            pontuacaoPMJQuery.setParameter("numPartida", numPartida);
            Integer pontuacaoPMJ;
            try {
                pontuacaoPMJ = Integer.parseInt(( String) pontuacaoPMJQuery.getSingleResult());
            } catch (NoResultException nre) {
                pontuacaoPMJ = null;
            }

            Query pontuacaoPJUQuery = em.createQuery(
                    """
                    SELECT p.pontuacao FROM Partida_Jogador_Unico p 
                    WHERE p.partida.jogador.id = :idJogador AND p.partida.id.num = :numPartida ORDER BY p.pontuacao DESC
                    """
            );
            pontuacaoPJUQuery.setParameter("idJogador", idJogador);
            pontuacaoPJUQuery.setParameter("numPartida", numPartida);
            Integer pontuacaoPJU;
            try {
                pontuacaoPJU = Integer.parseInt( (String) pontuacaoPJUQuery.getSingleResult());
            } catch (NoResultException nre) {
                pontuacaoPJU = null;
            }

            if (pontuacaoPMJ != null && pontuacaoPMJ >= limitePontos || pontuacaoPJU != null && pontuacaoPJU >= limitePontos) {
                Query insertQuery = em.createNativeQuery(
                        """
                        INSERT INTO Jogador_Cracha(id_jogador, ref_jogo, nome_cracha)
                        VALUES (?, ?, ?)
                        """
                );
                insertQuery.setParameter(1, idJogador);
                insertQuery.setParameter(2, refJogo);
                insertQuery.setParameter(3, nomeCracha);
                insertQuery.executeUpdate();
            }

            commitBusinessTransaction();
        } catch (Exception e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public Integer iniciarConversa(Integer idJogador, String nomeConversa) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call iniciarConversaLógica(?,?,?)")) {
            f.registerOutParameter(1, Types.INTEGER);
            f.setInt(2, idJogador);
            f.setString(3, nomeConversa);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
            return f.getInt(1);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public void juntarConversa(Integer idJogador, Integer idConversa) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call juntarConversaLógica(?,?)")) {
            f.setInt(1, idJogador);
            f.setInt(2, idConversa);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public void enviarMensagem(Integer idJogador, Integer idConversa, String mensagem) {
        Connection cn = getConnection();
        int currIL;
        try {
            currIL = cn.getTransactionIsolation();
            if(currIL < Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (CallableStatement f = cn.prepareCall("call enviarMensagemLógica(?,?,?)")) {
            f.setInt(1, idJogador);
            f.setInt(2, idConversa);
            f.setString(3, mensagem);
            f.execute();
            commitBusinessTransaction();
            if (cn.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED)
                cn.setTransactionIsolation(currIL);
        } catch (SQLException e) {
            rollbackBusinessTransaction();
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> jogadorTotalInfo() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM jogadorTotalInfo");
            return q.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer aumentarPontosCrachaOtimista(String nomeCracha, String refJogo) {
        try {
            getBusinessTransaction();
            Cracha cracha = em.find(Cracha.class, new Cracha.CrachaId(nomeCracha, refJogo));
            cracha.setLimitePontos((int) (cracha.getLimitePontos() * 1.2));
            commitBusinessTransaction();
            return cracha.getLimitePontos();
        } catch (RollbackException | OptimisticLockException e) {
            if(e.getCause() instanceof OptimisticLockException || e instanceof OptimisticLockException) {
                if (em.getTransaction().isActive())
                    rollbackBusinessTransaction();
                throw new RuntimeException("Erro de concorrência");
            }
            else throw e;
        }
    }

    public Integer aumentarPontosCrachaPessimista(String nomeCracha, String refJogo) {
        try {
            getBusinessTransaction();
            Cracha cracha = em.find(Cracha.class, new Cracha.CrachaId(nomeCracha, refJogo), LockModeType.PESSIMISTIC_READ);
            cracha.setLimitePontos((int) (cracha.getLimitePontos() * 1.2));
            commitBusinessTransaction();
            return cracha.getLimitePontos();
        } catch (RollbackException | PessimisticLockException e) {
            if(e.getCause() instanceof PessimisticLockException || e instanceof PessimisticLockException) {
                if (em.getTransaction().isActive())
                    rollbackBusinessTransaction();
                throw new RuntimeException("Erro de concorrência");
            }
            else throw e;
        }
    }
 }
