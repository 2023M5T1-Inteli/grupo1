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

No decorrer deste módulo, cada grupo redigirá a documentação do seu projeto no arquivo [docs/index.md](docs/index.md). Vamos verificar se você consegue fazer modificações na documentação do projeto a partir do seu computador. Para fazer esta validação o seu usuário já deve constar como um dos colaboradores do repositório.

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

15.  Escolha um integrante do grupo para ser o **gerente do repositório**. Ele será responsável por fazer os *merges*. Este integrante deverá acessar a lista de *pull requests* e realizar o checkout do *default branch*.

![Checkout do default branch.](docs/img/vscode-merge1.png)

16. O **gerente do repositório** deverá fazer o *checkout* do *pull request* a ser processado.

![Checkout do pull request.](docs/img/vscode-merge2.png)

17. O **gerente do repositório** deverá verificar o que foi modificado e, se estiver de acordo, realizar a operação de *merge*.

![Criação do commit do merge.](docs/img/vscode-merge3.png)

18. O **gerente do repositório** deverá confirmar a execução da operação.

![Confirmação da operação de merge.](docs/img/vscode-merge4.png)

19. O **gerente do repositório** deverá repetir os passos 16 a 18 até que todos os *pull requests* tenham sido processados.

20. O **gerente do repositório** deverá chavear para o *branch* **master**.

![Checkout do branch master.](docs/img/vscode-merge5.png)

21. O **gerente do repositório** deverá executar uma operação de *pull* para trazer para seu repositório local as últimas modificações realizadas.

![Execução da operação de pull.](docs/img/vscode-merge6.png)

22. O **gerente do repositório** poderá verificar se todas as modificações dos branches foram incorporadas na sua cópia de trabalho do *branch* **master**.

![Verificação da cópia de trabalho do master.](docs/img/vscode-merge7.png)

23. O conteúdo da pasta **docs** é publicado em um site GitHub Pages. O endereço é montado a partir do usuário/organização e do nome do repositório.

![Página inicial do GitHub Pages.](docs/img/github-pages.png)

## Validação da execução dos programas

Este repositório fornece um programa-exemplo que demonstra o uso da biblioteca GDAL.

Procedimento para executar o programa-exemplo:

1. No Visual Studio Code, navegue até a classe **AppDted** que está no pacote **br.edu.inteli.cc.m5.grupo**.

![Navegação até a classe AppDted.](docs/img/vscode-java-app.png)

2. Execute a classe e verifique o resultado da execução.

![Execução e verificação do resultado.](docs/img/vscode-exec-result.png)


## Validação da geração do artigo

O artigo é editado no formato *Markdown*, mas é possível gerar um arquivo PDF com uma formatação próxima à utilizada em publicações científicas.

Procedimento para gerar o artigo em PDF:

1. No Visual Studio Code, vá até a pasta `/artigo` e abra o arquivo `artigo-grupoN.md`.

![Abertura do arquivo com o artigo.](docs/img/vscode-abrir-artigo.png)

2. Edite o artigo (por exemplo, alterando os nomes dos autores) e salve o arquivo.

![Edição dos nomes dos autores.](docs/img/vscode-artigo-autores.png)

3. Pressione o atalho **Ctrl+K P** (pressione simultaneamente **Control** e **K**, solte, e a seguir pressione **P**). Escolha a opção **pdf renderer**.

![Geração do artigo no formato PDF.](docs/img/vscode-artigo-pdf.png)

4. Abra o arquivo **artigo-grupoN.pdf** e verifique o resultado após a sua edição.

![Resultado da geração do PDF.](docs/img/vscode-artigo-resultado.png)