# Documentação Spotippos API

Esse é o resultado do desafio. Necessita de MAVEN 3, JAVA 7 ou 8. Utilizei o banco de dados em memória e SpringRest/SpringBoot. Não vi a necessidade aqui de usar nenhum VM ou containers devido a simplicidade, mas em caso de crescimento de complexidade ou extesão do projeto eu consideraria usar um container (Docker). 

Para rodar no Maven envie o comando:

    $ mvn clean install    # para instalar as dependencias
    $ mvn spring-boot:run  # para rodar o built-in tomcat

## Endpoints

1. Home: A home é apenas uma string de boas vindas.
2. POST /properties: 

    Em caso de sucesso teremos o response:
    
        Response code: 200
        Response body: JSON (Content-Type:application/json;charset=UTF-8)
        
        {
          "id": 8001,
          "title": "Imóvel código 665, com 1 quarto e 1 banheiro",
          "price": 540000,
          "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "x": 667,
          "y": 556,
          "beds": 1,
          "baths": 1,
          "provinces" : ["Ruja"],
          "squareMeters": 42
        }
    
    Em caso de erro será retornado um JSON com o codigo 400 com uma mensagem específica do erro (segundo as regras das propriedades de Spotippos):
    
        Response code: 400
        Response body: JSON (Content-Type:application/json;charset=UTF-8)
            
        {
            "errorMessage": "Propriedade fora dos limites de Spotippos. X deve ser maior igual a zero e menor igual a 1400", 
            "errorCode": 400
        }
    
3. GET /properties/{id}
    
    Response code: 200
    Response body: JSON (Content-Type:application/json;charset=UTF-8)

        {
          "id": 665,
          "title": "Imóvel código 665, com 1 quarto e 1 banheiro",
          "price": 540000,
          "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "x": 667,
          "y": 556,
          "beds": 1,
          "baths": 1,
          "provinces" : ["Ruja"],
          "squareMeters": 42
        }
    
    Response code: 404
    Response body: JSON (Content-Type:application/json;charset=UTF-8)

        {
          "errorMessage": "Propriedade não encontrada",
          "errorCode": 404
        }

4. GET /properties?ax={integer}&ay={integer}&bx={integer}&by={integer}
    
    Em caso de sucesso:

        Response code: 200
        Response body: JSON (Content-Type:application/json;charset=UTF-8)
           
        {
          "foundProperties": 3,
          "properties": [
            {
              "id": 783,
              "x": 17,
              "y": 4,
              "title": "Imóvel código 783, com 5 quartos e 4 banheiros.",
              "price": 1915000,
              "description": "Officia elit ipsum excepteur mollit nulla velit commodo occaecat sint in minim duis qui tempor. Cillum nostrud voluptate commodo non mollit magna laborum pariatur enim ad duis ipsum magna.",
              "beds": 5,
              "baths": 4,
              "squareMeters": 191,
              "provices": [
                "Scavy"
              ]
            },
            {
              "id": 1268,
              "x": 39,
              "y": 7,
              "title": "Imóvel código 1268, com 5 quartos e 4 banheiros.",
              "price": 1714000,
              "description": "Laborum tempor eiusmod nostrud irure adipisicing deserunt commodo ullamco. Esse qui reprehenderit et Lorem elit aute.",
              "beds": 5,
              "baths": 4,
              "squareMeters": 169,
              "provices": [
                "Scavy"
              ]
            },
            {
              "id": 2969,
              "x": 31,
              "y": 8,
              "title": "Imóvel código 2969, com 2 quartos e 1 banheiros.",
              "price": 474000,
              "description": "Ad excepteur ex excepteur nulla laboris reprehenderit. Dolor non qui ullamco exercitation veniam esse adipisicing laborum id pariatur nostrud velit laboris minim.",
              "beds": 2,
              "baths": 1,
              "squareMeters": 47,
              "provices": [
                "Scavy"
              ]
            }
          ]
        }
    
    Caso não se ache nada:

        Response code: 200
        Response body: JSON (Content-Type:application/json;charset=UTF-8)
        
            {
              "foundProperties": 0,
              "properties": []
            }        
            
            
## Melhorias
            
Fazer rodar no tomcat já existente.