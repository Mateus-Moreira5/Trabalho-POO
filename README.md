# 🎓 Sistema de Gestão Escolar - POO
Sistema desenvolvido em Java para gerenciamento de estudantes, disciplinas e notas utilizando coleções Java (List, Set, Map).
- Integrantes:
  - Mateus Moreira Fernandes.
  - Ian Brito Ribeiro de Castro.
  - Caio Vitor Campelo Alcântara.


## 📋 Funcionalidades

- **Cadastro de Estudantes** - Lista ordenável por nome
- **Controle de Disciplinas** - Evita duplicatas usando Set
- **Histórico de Notas** - Associa estudantes às disciplinas usando Map
- **Relatórios** - Médias, alunos aprovados, rankings

## 🏗️ Estrutura do Projeto

### Classes Principais
- `Estudante` - ID e nome do estudante
- `Disciplina` - Código e nome da disciplina  
- `ListaEstudante` - Gerencia lista de estudantes (ArrayList)
- `ListaDisciplina` - Controla disciplinas (LinkedHashSet)
- `ListaNota` - Gerencia notas e matrículas
- `App` - Programa principal com relatórios

## 🚀 Como Executar

```bash
# Compilar
javac *.java

# Executar
java App
