# Importando o módulo Path do pathlib
from pathlib import Path

# Definindo o caminho e o nome do arquivo
caminho_arquivo = Path('arquivo.txt')

# Criando e abrindo o arquivo para escrita
with open(caminho_arquivo, 'w') as arquivo:
    arquivo.write('Olá, mundo Python!')
