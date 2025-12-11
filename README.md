# 📘 Projeto de Testes Automatizados – Automation Exercise

Este projeto foi desenvolvido para a atividade proposta na disciplina de **Testes de Software**.
A ideia foi criar um conjunto de testes automatizados usando **Selenium WebDriver** e **JUnit**, aplicando também o padrão **Page Object Model (POM)** para organizar o código.

O site usado para os testes foi o **Automation Exercise**, que é próprio para praticar automação:
[https://automationexercise.com/](https://automationexercise.com/)

---

## Objetivos do Trabalho

Os objetivos pedidos na atividade foram:

1. Automatizar o **cadastro de um novo usuário**.
2. Automatizar o **login com credenciais inválidas**.
3. Organizar o código usando o **POM (Page Object Model)**.
4. Gerar **screenshots quando algum teste falhar**.
5. Usar um framework de testes (no caso, **JUnit 5**).


---

## Cenários Testados

### Cadastro de novo usuário (válido)

* Acessa a tela de Signup/Login
* Preenche nome + e-mail
* Preenche o restante do formulário
* Finaliza a criação da conta
* Verifica se o usuário ficou logado

### Login inválido

* Acessa a tela de login
* Envia um email inexistente
* Verifica a mensagem de erro

---

## Captura de Screenshot

Sempre que um teste dá erro, o método `screenshot()` salva automaticamente uma imagem dentro de uma pasta chamada **screenshots**, que é criada na raiz do projeto.

Isso ajuda a identificar visualmente o que aconteceu no momento da falha.

Obs.: a pasta só aparece **se houver falha**.


## 🧰 Tecnologias Utilizadas

* Java 11
* Selenium WebDriver 4
* JUnit 5
* Maven
* Page Object Model (POM)

---

## ✍️ Considerações Finais 

Foi um projeto importante para entender melhor como funciona automação de testes na prática.
A parte do POM deixou o código bem mais organizado, e ver o Selenium funcionando diretamente no navegador realmente ajuda a visualizar o fluxo.
A captura de screenshot também foi útil para aprender como identificar falhas automaticamente.

Esse trabalho ajudou a fixar o uso de ferramentas reais usadas por QAs no mercado.
