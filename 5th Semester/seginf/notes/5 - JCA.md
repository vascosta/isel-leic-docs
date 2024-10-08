# __JCA__

## __Arquitetura__

* Arquitetura baseada em ___Cryptographic Service Provider___ (CSP): _package_ ou conjunto de _packages_ que implementam 1 ou mais mecanismos criptográficos.

## ___Engine Classes___

> Definição abstrata de um mecanismo criptográfico.

* A criação dos objetos é realizada através de métodos estáticos ```getInstance()```.

* Os algoritmos concretos e as implementações contretas (_providers_) são identificados por _strings_.

### __Classes__

* ```Cipher```

* ```Mac```

* ```Signature```

* ```MessageDigest```

* ```KeyGenerator```

* ```KeyPairGenerator```

* ```SecureRandom```

* ...

### __Métodos ```getInstance()```__

* ```getInstance(String transformation)```: _Provider default_.

* ```getInstance(String transformation, String provider)```: _Provider_ específico.

* ```getInstance(String transformation, Provider provider)```: _Provider_ específico.

### ___Delayed Provider Selection___

> A seleção do _provider_ adequado é adiada até à iniciação com a chave, o que permite a seleção do _provider_ com base no tipo concreto da chave.

### __Exemplo__

* Geração de chave simétrica aleatória a partir da ```SecureRandom```:

    ```java
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");

    // Opcional, se não passar um SecureRandom ao método init de keyGen
    SecureRandom secRandom = new SecureRandom();

    // Opcional
    keyGen.init(secRandom);

    SecretKey key = keyGen.generateKey();

    // Gera o objeto da cifra simetrica
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

    // Associa a chave key a cifra
    cipher.init(Cipher.ENCRYPT_MODE, key);

    // Continuar com processo de cifra...
    ```

## ___Specification Classes___

> Representações normalizadas e transparentes de objetos criptográficos (chaves, parâmetros de algoritmos, etc).

## ___Providers___

> Fornecem a implementação para as _engine classes_.

### __Instalação__

* Colocar o _package_ na _classpath_ ou na diretoria de extensões.

* Registar no ficheiro ``java.security``.

### __Classe ``Security``__

> Alternativa ao ficheiro ``java.security``.

* Registo dinâmico de _providers_.

* Listagem de _providers_ e algoritmos.

## __Classe ```Cipher```__

### __```init()```__

Parâmetros:

* Modo: Cifra, decifra, _wrap_, _unwrap_, etc.

* Chave.

* Parâmetros específicos do algoritmo.

* Gerador aleatório.

### __Métodos de Cifra__

* ```update()```: Continua a operação incremental.

* ```doFinal()```: Finaliza a operação incremental.

* ```wrap()```: Cifra uma chave.

* ```unwrap()```: Decifra uma chave.

### __Exemplos__

* Cifrar uma mensagem texto simples:

    ```java
    // Associa a chave key a cifra
    cipher.init(Cipher.ENCRYPT_MODE, key);

    // Mensagem a ser cifrada
    String msg = new String("Mensagem secreta!");

    // Cifra mensagem com chave key
    byte[] bytes = cipher.doFinal(msg.getBytes());
    ```

#

* Decifrar uma mensagem cifrada (usando a cifra anterior):

    ```java
    // Decifra com mesma chave da cifra
    cipher.init(Cipher.DECRYPT_MODE, key);

    byte[] bytes2 = cipher.doFinal(bytes);

    // Mostra a mensagem original
    System.out.println(new String(bytes2));
    ```

#

* Cifrar texto da entrada padrão parcialmente:

    ```java
    // Obtém linha da entrada padrão in (Scanner) e adiciona
    // quebra de linha que é removida pelo nextLine
    nl = in.nextLine() + System.lineSeparator();

    while (! System.lineSeparator().equals(nl)) {
        // Gera cifra parcial em tmp e concatena no criptograma c
        tmp = cipher.update(nl.getBytes());
        c = concatBytes(c, tmp);

        // Obtém próxima linha da entrada padrão
        nl = in.nextLine() + System.lineSeparator();
    }

    // Finaliza cifra e concatena bytes finais no criptograma c
    tmp = cipher.doFinal();
    c = concatBytes(c, tmp);
    ```

## ___Streams___

### __```CipherInputStream```__

> Processa (cifra ou decifra) os _bytes_ lidos através do _stream_.

### __```CipherOutputStream```__

> Processa (cifra ou decifra) os _bytes_ escritos para o _stream_.

### __```DigestInputStream```__

> Processa (calcula o _hash_) os _bytes_ lidos através do _stream_.

### __```DigestOutputStream```__

> Processa (calcula o _hash_) os _bytes_ escritos para o _stream_.

### __Exemplo__

* Cifra texto da entrada padrão parcialmente e a apresenta na saída padrão:

    ```java
    // Cifra e escreve o criptograma na saída padrão
    CipherOutputStream cOutputStream = new CipherOutputStream(System.out, cipher);

    // Obtém linha da entrada padrão in (Scanner) e adiciona quebra de linha// que é removida pelo nextLine
    nl = in.nextLine() + System.lineSeparator();
    while (! System.lineSeparator().equals(nl)) {
        // Escreve a cifra da mensagem na saída padrão
        cOutputStream.write(nl.getBytes(), 0, nl.getBytes().length);
        
        // Obtém próxima linha da entrada padrão
        nl = in.nextLine() + System.lineSeparator();
    }
    cOutputStream.close();
    ```

## __Parâmetros__


### __```AlgorithmParameters```__

> Representação opaca de parâmetros de algoritmos.

### __```AlgorithmParameterGenerator```__

> Gera parâmetros de algoritmos.

### __```AlgorithmParameterSpec```__

> Representação transparente de parâmetros de algoritmos.

* ```IvParameterSpec```: Vetor de inicialização.

* ```RsaKeyGenParameterSpec```: Parâmetros de geração de chaves RSA.

### __Exemplo__

* Gerar chave e IV a partir de valores estáticos:

    ```java
    // Gera os bytes para o vetor de bytes correspondente a chave
    byte[] keyBytes = {
        0x01, 0x23, 0x45, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef, 
        0x01, 0x23, 0x45, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef
    };

    // Gera os bytes para o vetor de bytes correspondente ao IV
    byte[] ivBytes = {
        (byte)0xef, (byte)0xcd, (byte)0xab, (byte)0x89, 0x67, 0x45, 0x23, 0x01, 
        (byte)0xef, (byte)0xcd, (byte)0xab, (byte)0x89, 0x67, 0x45, 0x23, 0x01
    };

    // Gera chave a partir do vetor de bytes (valor fixo, não aleatório)
    SecretKey key = new SecretKeySpec(keyBytes, "AES");

    // Gera IV a partir do vetor de bytes (valor fixo, não aleatório)
    IvParameterSpec iv = new IvParameterSpec(ivBytes);

    // Gera o objeto da cifra simetrica
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

    // Associa a chave key a cifra
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    // Continuar com a cifra de uma mensagem...
    ```

## __Chaves__

### __Interface ```Key```__

* ```String getAlgorithm()```: Algoritmo da chave.

* ```byte[] getEncoded()```: Codificação da chave.

* ```String getFormat()```: Formato da codificação.

### __Intefaces ```SecretKey```, ```PublicKey``` e ```PrivateKey```__

> Estendem a interface ```Key``` e não acrescentam métodos.

### __Classe ```KeyPair```__

> Contém uma ```PublicKey``` e uma ```PrivateKey```.

### __Classes ```KeyGenerator``` e ```KeyPairGenerator```__

> Geram chaves.

### __Representações de Chaves__

#### __Opaca__

> Chaves __sem__ acesso aos seus constituintes.

* Derivadas da interface ```Key```.

* Específicas de cada _provider_.

* Geradas por ```KeyGenerator``` ou ```KeyPairGenerator```.

#### __Transparente__

> Chaves __com__ acesso aos seus constituintes.

* Derivadas da interface ```KeySpec```.

* Os _packages_ ``java.security.spec`` e ``javax.crypto.spec`` definem um conjunto de classes ``<nome>Spec`` com interface normalizada para o acesso aos constituintes das chave de diversos algoritmos.

* ``RsaPublicKeySpec``, ``DESKeySpec``, ``SecretKeySpec``, etc.

### ``KeyFactory``

> _Engine class_ para conversão entre representações opacas e transparentes.

### __Exemplos__

* Representação opaca das chaves:

    ```java
    // Cria objeto KeyPair
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

    // Inicia o tamanho da chave
    keyPairGen.initialize(2048);

    // Gera o par de chaves
    KeyPair pair = keyPairGen.generateKeyPair();

    // Obtém a chave privada
    PrivateKey privKey = pair.getPrivate();

    // Obtém a chave pública
    PublicKey publicKey = pair.getPublic();
    ```

#

* Representação transparente das chaves:

    ```java
    // KeyFactory para obter detalhes das chaves
    KeyFactory kf = KeyFactory.getInstance(keyPairGen.getAlgorithm());

    // Conversões do objeto opaco para o transparente
    RSAPrivateKeySpec privKeySpec = kf.getKeySpec(privKey, RSAPrivateKeySpec.class);

    RSAPublicKeySpec publicKeySpec = kf.getKeySpec(publicKey, RSAPublicKeySpec.class);

    // Mostrar dados transparentes das chaves
    System.out.println("Private Modulus: " + privKeySpec.getModulus());System.out.println("Private Exponent: " + privKeySpec.getPrivateExponent());

    System.out.println("Public Modulus: " + publicKeySpec.getModulus());System.out.println("Public Exponent: " + publicKeySpec.getPublicExponent());
    ```

## __Classe ```Mac```__

### ``init()``

Parâmetros:

* Chave.

* Parâmetros específicos do algoritmo.

### __Métodos de Geração de Marca__

* ```update()```: Continua a operação incremental.

* ```doFinal()```: Finaliza a operação incremental, retornando a marca.

### __Exemplo__

* Gerar HMAC-SHA256 de uma mensagem texto:

    ```java
    byte[] someImportantMessage = "This is a very important message";

    // Gerador de chaves HMAC-SHA256
    KeyGenerator secretKeyGenerator = KeyGenerator.getInstance("HmacSHA256");

    // Gera a chave simétrica
    SecretKey key = secretKeyGenerator.generateKey();

    // Obtém objeto MAC e inicia com a chave
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(key);

    // Computa o HMAC da mensagem
    byte[] tag = mac.doFinal(someImportantMessage.getBytes());
    ```

## __Classe ```Signature```__

### __```initSign()```__

Parâmetros:

* Chave privada.

* Gerador aleatório.

### __```initVerify()```__

Parâmetros:

* Chave pública

### __Métodos de Geração de Assinatura__

* ```update()```: Continua a operação incremental.

* ```sign()```: Finaliza a operação incremental, retornando a assinatura.

### __Métodos de Verificação de Assinatura__

* ```update()```: Continua a operação incremental.

* ```verify()```: Finaliza a operação incremental, retornando ```true``` se a validade (___true/false___) da assinatura.

### __Exemplos__

* Assinar mensagem texto com SHA256 with RSA

    * Gerar chaves assimétricas:
    
        ```java
        String m = "Mensagem texto a ser assinada";
        
        // Uso de assinatura digital baseada no RSA
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        
        // Como exemplo, gerar uma chave RSA de 4096 bits
        kg.initialize(4096);
        
        // Gerar o par de chaves
        KeyPair keyPair = kg.generateKeyPair();
        
        // Obter as chaves pública e privada
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privKey = keyPair.getPrivate();
        ```

    * Processo de assinatura:

        ```java
        // Obter uma instância do algoritmo de assinatura SHA256withRSA
        Signature sign = Signature.getInstance("SHA256withRSA");
        
        // Iniciar o objeto com a chave privada (para a geração da assinatura)
        sign.initSign(privKey);
        
        // Solicitação da assinatura com o método update
        sign.update(m.getBytes());
        
        // Finalizar a assinatura em si
        byte[] s = sign.sign();
        ```

    * Processo de verificação:

        ```java
        // Precisa-se inicializar o objeto em modo de verificação utilizando a porção pública da chave
        sign.initVerify(pubKey);
        
        // Associar mensagem a ser verificada ao objeto de verificação
        sign.update(m.getBytes());
        
        // Finalmente, usar o método verify() para verificar a assinatura
        if (sign.verify(s)) 
            System.out.println("Signature matches!");
        else 
            System.out.println("Signature does not match!");
        ```