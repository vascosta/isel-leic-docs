package test;

import businessLayer.BLService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class AppTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaex");
        EntityManager em = emf.createEntityManager();
        try  {
            BLService blService = new BLService(em);
            Thread otimisticTh1 = new MyThread(blService);
            Thread otimisticTh2 = new MyThread(blService);

            /**
             * Test for concurrency update using optimistic lock
             *
             * Expected result -> An Exception is thrown with the message: "Erro de concorrência"
             * Both threads try to update the same entity at the same time, so both transactions
             * will be aborted.
             **/

            otimisticTh1.start();
            otimisticTh2.start();

            otimisticTh1.join();
            otimisticTh2.join();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static class MyThread extends Thread {
        private final BLService blService;
        public MyThread(BLService blS){ blService = blS; }
        public void run() {
            blService.aumentarPontosCrachaOtimista("C1", "JG1");
        }
    }
}
