🎓 Sistema de Gestão Escolar
Sistema desenvolvido em Java para gerenciamento de estudantes, disciplinas e notas utilizando coleções do Java.

📋 Funcionalidades
Cadastro de Estudantes - Lista ordenável por nome.
Controle de Disciplinas - Evita duplicatas.
Histórico de Notas - Associa estudantes às disciplinas.
Relatórios - Médias, alunos aprovados, rankings.

🏗️ Estrutura do Projeto
📦 Sistema Escolar
├── 📄 Estudante.java          # Classe estudante (id, nome)
├── 📄 Disciplina.java         # Classe disciplina (código, nome)  
├── 📄 Matricula.java          # Classe matrícula (disciplina, nota)
├── 📄 ListaEstudantes.java    # Gerencia lista de estudantes
├── 📄 CadastroDisciplinas.java # Controla disciplinas (Set)
├── 📄 HistoricoNotas.java     # Gerencia notas (Map)
└── 📄 App.java                # Programa principal

🚀 Como Executar
1. Compile todos os arquivos .java:
    Execute esse comando no cmd: "javac *.java".
2. Execute a classe principal:
    Execute esse comando no cmd: "java App".

📊 Coleções Utilizadas
List - ArrayList para estudantes.
Set - LinkedHashSet para disciplinas.
Map - HashMap para histórico de notas.

🎯 Objetivo
Trabalho acadêmico para demonstrar o uso prático das coleções Java (List, Set, Map) em um sistema real de gestão escolar.