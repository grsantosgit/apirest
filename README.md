https://github.com/grsantosgit/apirest
APIRest desnvolvida com Spring Boot, aproveitando todo ecosistema Spring como Spring Data, Security e Spring Core, utilizando Java 8 Maven e JPA (com implementação Hibernate)

Considerações do projeto acima: 
Foi utilizado Maven para gerenciamento de dependências e pacotes do ecositema Spring.
Na construção da APIRest foi tomado todo o cuidado com uma construção de uma api Rest utilizando os métodos corretamente (@GetMapping, @PostMapping, @PutMapping, @DeletetMapping) assim como versionamento da URI (/v1). 
Nesse projeto usei Spring Data para comunicação com banco de dados local (MySql) e manipulação dos objetos, tratando estes objetos corretament conforme a especificação JPA (Manipulação Transient, Managed e Detached), como implementação foi usado o Hibernate. 
Os Adapters da classe de Configuração já estão usando a implementação do Spring MVC 5 se aproveitando das novas features do Java 8 das interfaces com métodos Defaut.
Utilizei Spring Security para propor um nível de segurança na API, com níveis de User para métodos gets e de Admin para aqueles que desejam fazer de algum tipo de alteração como Post, Put e Delete
Utilizado Postman para testes das URIS.
e Github como forma de versionamento do projeto.

