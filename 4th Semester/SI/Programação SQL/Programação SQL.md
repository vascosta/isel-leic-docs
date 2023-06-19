# __Programação__ ___SQL___

## __Tipos de Data__

* SERIAL
* INTEGER
* DECIMAL(CASAS_TOTAIS, CASAS_DECIMAIS)
* VARCHAR(TAMANHO)
* TEXT
* DATE
* TIME

---

## __Tabelas__

E.g.:
```sql
CREATE TABLE IF NOT EXISTS TABLE1 (
  prop1 	    INTEGER NOT NULL,
  prop2 		DECIMAL(5,2) UNIQUE NOT NULL,
  prop_foreign 	TEXT NOT NULL,
  prop_date 	DATE CHECK (prop_date > '2000-01-01'),
  PRIMARY KEY(prop1),
  FOREIGN KEY(prop_foreign) REFERENCES TABLE2(prop)
);

DROP TABLE IF EXISTS TABLE1 CASCADE;
```

---

## __Declaração de Variáveis__

```sql
DECLARE
    name TIPO := valor (opcional);
```

__E.g.__:
```sql
DECLARE
    var1 INTEGER := 1;
    var2 DATE;
```

Também é possível guardar valores de um ___SELECT___ numa variável.

__E.g.__:
```sql
DECLARE
    var1 DECIMAL(5,2);

SELECT prop2 INTO var1 FROM TABLE1 WHERE prop1 = 1;
```

---

## __Instruções de Controle de Fluxo__

### ___IF___

```sql
IF expressão booleana THEN
    ...
ELSIF expressão booleana THEN
    ...
ELSE (opcional)
    ...
END IF;
```

__E.g.__:
```sql
DECLARE
    var1 INTEGER := 1;

IF var1 IS NULL THEN
		RAISE NOTICE 'var1 é null';
ELSEIF var1 = 1 THEN
        RAISE NOTICE 'var1 é 1';
ELSE
        RAISE NOTICE 'var1 não é null nem 1';
END IF;
```

---

### ___CASE___

```sql
CASE variável
    WHEN expressão THEN
        ...
    WHEN expressão THEN
        ...
    ELSE
        ...
END CASE
```

__E.g.__:
```sql
DECLARE
    var1 INTEGER := 1;

CASE var1
    WHEN NULL THEN
        RAISE NOTICE 'var1 é null';
    WHEN 1,2 THEN
        RAISE NOTICE 'var1 é 1 ou 2';
    ELSE
        RAISE NOTICE 'var1 não é null nem 1 nem 2';
END CASE
```

---

## __Ciclos__

* ``` EXIT WHEN expressão booleana ```
* ``` CONTINUE WHEN expressão booleana (opcional) ```

### ___WHILE___

```sql
WHILE expressão booleana LOOP
    ...
END LOOP
```

__E.g.__:
```sql
DECLARE
    var1 INTEGER := 1;

WHILE var1 < 10 LOOP
    RAISE NOTICE 'var1 = %', var1;
    var1 = var1 + 1;
END LOOP;
```

---

### ___FOR___

```sql
FOR target IN query LOOP
    ...
END LOOP
```

__E.g.__:
```sql
DECLARE var1 RECORD;

FOR var1 IN SELECT * FROM TABLE1 LOOP
    IF var.prop1 > 0 THEN
        CONTINUE;
    END IF;
    EXIT WHEN var.prop1 = 0;
END LOOP;
```

---

## __Exceções__

```sql
RAISE NOTICE/EXCEPTION 'mensagem';
RAISE NOTICE/EXCEPTION 'mensagem = %', variável;
```

__E.g.__:
```sql
DECLARE var1 INTEGER := 1;

RAISE NOTICE 'var1';
RAISE EXCEPTION 'var1 = %', var1;
```

---

## __Procedimento__

Parametros do tipo ``OUT`` são usados para retornar valores.

```sql
CREATE OR REPLACE PROCEDURE nome(OUT param1 tipo, param2 tipo)
LANGUAGE plpgsql AS $$
DECLARE
	...
BEGIN
	...
END;
$$;
```

---

## __Funções__

---





