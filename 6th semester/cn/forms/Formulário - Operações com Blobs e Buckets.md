```java
/* Variável de ambiente com chave
* GOOGLE_APPLICATION_CREDENTIALS=<pathname do ficheiro json com chave>
*/

/*
* Funções para manipulação de blobs e buckets
*/

StorageOptions options = StorageOptions.getDefaultInstance();

String projID = options.getProjectId();
Storage storage = options.getService();

/*
* Percorrer os buckets e os seus blobs de um projeto
*/

for (Bucket bucket : storage.list().iterateAll()) {
    // bucket.toString();
    for (Blob blob : bucket.list().iterateAll()) {
        // blob.toString();
    }
}

/*
* Criar um bucket
*/

Bucket bucket = storage.create(
    BucketInfo
        .newBuilder(bucketName)
        .setStorageClass(storageClass)
        .setLocation(location)
        .build()
);

/*
* Apagar um bucket
*/

Bucket bucket = storage.get(bucketName);
bucket.delete();

/*
* Criar um blob
*/

BlobInfo blobInfo = BlobInfo
    .newBuilder(blobId)
    .setContentType(contentType)
    .build();

/*
* Apagar um blob
*/

BlobId blobId = BlobId.of(bucketName, blobName);
Blob blob = storage.get(blobId);
blob.delete();

/*
* Upload de um blob para um bucket
*/

BlobId blobId = BlobId.of(bucketName, blobName);
BlobInfo blobInfo = BlobInfo
    .newBuilder(blobId)
    .setContentType(contentType) // String contentType = ".jpg";
    .build();

storage.create(blobInfo, content); // byte[] content 

/*
* Upload de um ficheiro para um blob e posteriormente para um bucket
*/

Path file = Paths.get(absFileName);
byte[] content = Files.readAllBytes(file);

BlobId blobId = BlobId.of(bucketName, blobName);
BlobInfo blobInfo = BlobInfo
    .newBuilder(blobId)
    .setContentType(contentType)
    .build();

storage.create(blobInfo, content);

/*
* Download de um blob
*/

BlobId blobId = BlobId.of(bucketName, blobName);
Blob blob = storage.get(blobId);
byte[] content = blob.getContent();

/*
* Download de um blob para um ficheiro
*/

BlobId blobId = BlobId.of(bucketName, blobName);
Blob blob = storage.get(blobId);
byte[] content = blob.getContent();

Path downloadTo = Paths.get(absFileName);
PrintStream writeTo = new PrintStream(Files.newOutputStream(downloadTo));
writeTo.write(content);
writeTo.close();
```