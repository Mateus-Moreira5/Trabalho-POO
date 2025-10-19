# 🎓 Sistema de Gestão Escolar - POO

## 👥 Integrantes do Grupo
- Mateus Moreira Fernandes.
- Ian Brito Ribeiro de Castro.
- Caio Vitor Campelo Alcântara.

## 📋 Descrição do Projeto
Sistema desenvolvido em Java para gerenciamento de estudantes, disciplinas e notas de uma escola, utilizando coleções Java para armazenamento e manipulação de dados em memória.

## 🎯 Justificativa das Escolhas das Coleções

### **List - ArrayList para Estudantes**
- **Escolha:** `ArrayList<Estudante>`
- **Justificativa:** Permite acesso rápido por índice, mantém ordem de inserção e é eficiente para buscas sequenciais. Ideal para lista de estudantes que precisa ser ordenada e acessada por posição.

### **Set - LinkedHashSet para Disciplinas**  
- **Escolha:** `LinkedHashSet<Disciplina>`
- **Justificativa:** Garante unicidade (evita disciplinas duplicadas) e mantém a ordem de inserção, importante para exibir disciplinas na ordem em que foram cadastradas.

### **Map - HashMap para Notas**
- **Escolha:** `HashMap` para associação estudante-disciplina-nota
- **Justificativa:** Acesso rápido O(1) para buscar notas por estudante e disciplina, estrutura ideal para relações chave-valor.

## 🚀 Como Executar o Programa

### Passo a Passo:
```bash
# 1. Compilar todos os arquivos Java
javac *.java

# 2. Executar o programa principal
java App

# 3. O arquivo output.txt será gerado automaticamente
