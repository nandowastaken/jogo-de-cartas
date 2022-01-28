# Jogo de Cartas
Um jogo de cartas desenvolvido com programação orientada a objetos, o usuário pode escolher de 3 a 5 rodadas e é jogado por 4 jogadores, a cada rodada, uma carta de um certo naipe são sorteados para cada jogador, e vence o jogador com a maior pontuação, no final de todas as rodadas, o jogador com o maior número de pontos é anunciado vencedor.

### Funcionalidades
* Todo o código do jogo referente a jogadores é feito com arrays, portanto, a quantidade de jogadores é escalável, sem a necessidade de mudar o código, apenas o tamanho do array;
* O jogador pode escolher quantos rounds o jogo vai durar, mas ele também pode parar o jogo se não quiser continuar mais, com o vencedor sendo anunciado com a quantidade de pontos ganhas até aquele ponto do jogo;
* A classe ManusearJogo() controla os dados do jogo, os jogadores e as cartas, ela quem sorteia as cartas para os jogadores, atribuem os pontos etc;
* As classes referentes às cartas e aos jogadores guardam informações deles, como a carta que um jogador tem, ou o valor que uma carta tem; 
