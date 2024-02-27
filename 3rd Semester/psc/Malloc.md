# Memória em C

## Malloc
`void *malloc(size_t size)` -> aloca size bytes de memória e retorna um ponteiro 
para o primeiro byte alocado

E.g.:
```c
int *array;
int num_elem = 10;
size_t elem_size = sizeof(int);

array = malloc(num_elem * elem_size);
.
.
.
free(array);
```

## Memcpy

`void *memcpy(void *dest, const void * src, size_t n)` -> copia n bytes de src para dest

E.g.:
```c
int main () {
    const char src[50] = "https://www.tutorialspoint.com";
    char dest[50];
    strcpy(dest,"Heloooo!!");
    printf("Before memcpy dest = %s\n", dest);
    memcpy(dest, src, strlen(src)+1);
    printf("After memcpy dest = %s\n", dest);
   
   return(0);
}

// Before memcpy dest = Heloooo!!
// After memcpy dest = https://www.tutorialspoint.com
```