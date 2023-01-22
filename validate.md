# Validação da preparação no seu computador

Após realizar a [instalação do ambiente no seu computador](install.md), faça os procedimentos de validação que estão nesta página.

Procedimentos iniciais:

1. Verifique se foi criado o *fork* deste repositório para o seu grupo. Embora seja possível realizar estes procedimentos de validação clonando este modelo (template) de repositório, é preferível já trabalhar no repositório do seu próprio grupo. Para a elaboração destas instruções vamos usar o repositório que está em https://github.com/tmsski/DemonstracaoM5 como o *forked repo*, mas ao executar no seu computador você deverá substituir a URL por aquela do repositório do seu grupo.

![Exemplo de *forked repo*.](./docs/img/fork-repositorio.png)

2. Copie a URL do seu repositório para poder realizar a clonagem.

![Clonagem do repositório.](./docs/img/clone-repo.png)
   
3. Execute o Visual Studio Code e faça a operação de clonagem do repositório.

![Clonagem do repositório utilizando Visual Studio Code.](./docs/img/clone-repo-vscode.png)

4. Selecione a pasta (ou crie uma nova pasta) onde deverá ficar o projeto no seu computador.

![Definição da pasta do projeto.](docs/img/select-clone-folder.png)

5. Verifique se os arquivos do repositório agora estão presentes no seu computador.

![Arquivos da pasta de trabalho.](docs/img/vscode-work-folder.png)

## Validação da edição da documentação

No decorrer deste módulo, cada grupo redigirá a documentação do seu projeto no arquivo [docs/index.md](docs/index.md). Para fazer esta validação o seu usuário já deve constar como um dos colaboradores do repositório.

1. Abra a sua cópia de trabalho do arquivo `docs/index.md`.

![Arquivo docs/index.md](docs/img/vscode-docs-index.png)

2. Inicie a criação de um novo *branch*.

![Criação de novo branch.](docs/img/vscode-create-branch.png)

3. Dê um nome para o seu novo *branch* (o exemplo dá o nome **autor-prof** pois esta alteração é para colocar o professor como um dos autores). Combine com os seus colegas para que cada um dê um nome diferente para o seu *branch*.

![Definição do nome do brach.](docs/img/vscode-branch-name.png)

4. Coloque o seu nome como um dos autores, substituindo uma das linhas com o conteúdo **"Aluno <número>"**. Combine com os seus colegas para que cada um altere uma linha diferente do arquivo.

![Alteração do conteúdo de um arquivo.](docs/img/vscode-change-branch.png)

5. Salve o arquivo (CTRL-S) e faça o *commit* da alteração. Lembre-se de que isto gravará a alteração apenas no seu repositório local (no seu computador).

![*Commit* da alteração.](docs/img/vscode-commit.png)

6. Publique o *branch* no repositório remoto.

![Publicação do *branch*.](docs/img/vscode-publish-branch.png)

7. Faça a autenticação no GitHub utilizando o *browser*.

![Autenticação no GitHub pelo browser.](docs/img/github-auth-browser.png)

8. Quando o *browser* for aberto, verifique e autorize o acesso.

9. Acesse a página do seu repositório no GitHub e verifique se o seu *branch* foi criado.

![Network do repositório Git.](docs/img/github-network.png)

10. Após vários colegas realizarem este procedimento, teremos diversos *branches* no diagrama.

![Network do repositório com diversos branches.](docs/img/github-network-several.png)

11. Faça a criação de um *Pull Request*. É possível fazer isto pelo Visual Studio Code ou pelo próprio site do GitHub. Os passos a seguir mostram o procedimento utilizando o Visual Studio Code.

![Início da criação de um pull request pelo Visual Studio Code.](docs/img/vscode-create-pull-request.png)

12. Preencha os campos, prestando atenção se os repositórios e branches correspondem aos que você deseja, e faça a criação do *Pull Request*.

![Criação do pull request pelo Visual Studio Code.](docs/img/vscode-create-pull-request-2.png)

13. Se acessar o site do seu repositório no GitHub, você deve poder ver o *Pull Request* que foi criado.

![Pull request criado no repositório.](docs/img/github-pull-request-created.png)

14. Depois que todos do grupo tiverem criado seus *pull requests*, é possível visualizar todos eles no próprio Visual Studio Code.

![Visualização dos pull requests no Visual Studio Code.](docs/img/vscode-refresh-pull-requests.png)


## Validação da execução dos programas

## Validação da geração do artigo