# Malloc

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