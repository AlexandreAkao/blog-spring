## Área Administrativa
```
CRUD * de notícias
CRUD * de categorias
Upload de imagens por notícia
```
> **admin.NewsController**

<sub>Create</sub>
```
FuncaoJava | MethodHTTP | RetornoSucesso        |  RetornoErro | StatusNoProj
Read       | POST       | *__code__* ➝ retorno |  *__code__*  | estado
```

Action | Method | Suc. | Err. | URL |
--- | :---: | :--- | :---: | :---
Create  | POST   | *__201__* | *__404__* | OK
ReadAll | GET    | *__200__* | *__404__* | OK
Read    | GET    | *__200__* | *__404__* | estado
Update  | PUT    | *__204__* | *__404__* | OK
Delete  | DELETE | *__200__* | *__404__* | OK