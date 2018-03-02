# Exercício: arquitetura em 3 camadas e padrões
Considere a especificação do módulo de acesso a conta corrente do Banco Nossa Grana (ver abaixo). Implemente um programa Java que atenda os requisitos desta especificação utilizando as orientações relativas a arquitetura de software e padrões de projeto vistas até então.

Para simplificar a troca de dados os seguintes arquivos são fornecidos:

* Persistencia.java:
  * modulo Java com métodos para leitura e gravação de dados relativos a contas corrente e movimentações de contas corrente (operações de depósito e retirada).
* BDContasBNG.txt:
  * arquivo exemplo com dados de contas corrente.
* BDOperBNG.txt:
  * arquivo exemplo com dados de operações sobre contas corrente.

# Especificação de software
## Modulo de acesso a conta corrente do Banco Nossa Grana

O módulo de acesso a conta corrente é um módulo simples que deve permitir ao funcionário do banco executar operações básicas sobre as contas correntes:
* Consultar saldo
* Consultar últimos movimentos
* Efetuar depósitos
* Efetuar retiradas

O sistema é composto basicamente por duas telas:
* Tela de identificação da conta corrente: nesta tela o usuário informa o número da conta corrente que deseja acessar.

* Tela de operações: nesta tela o usuário visualiza o saldo e os últimos movimentos da conta informada e pode executar operações de depósito e retirada.

Nesta primeira versão os dados das contas são mantidos em um arquivo texto. É necessário garantir que sempre que o sistema é encerrado as movimentações atualizadas das contas são salvas neste arquivo.
As contas desse banco, porém, tem um comportamento específico. Quanto mais dinheiro o cliente tem depositado mais o banco valoriza seus depósitos. Todos as contas iniciam na categoria “Silver” e zeradas. Contas “Silver” não têm seus depósitos valorizados, ou seja, o valor creditado é exatamente o valor depositado pelo cliente. Quando o saldo da conta atinge ou ultrapassa R$ 50.000,00, a conta passa para a categoria “Gold”. Contas “Gold” têm seus depósitos valorizados em 1%. Neste caso se o cliente depositar R$ 1.000,00 o valor creditado será de R$ 1.010,00. Finalmente se o saldo da conta atinge ou supera os R$ 200.000,00, a conta passa para a categoria “Platinum”. Contas “Platinum” têm seus depósitos valorizados em 2,5%. A verificação de “upgrade” da conta se dá via operação de depósito, e não é possível que um cliente faça “upgrade” diretamente de “Silver” para “Platinum” em uma única operação.
Quando o saldo da conta diminui, em função de uma operação de retirada/saque, a categoria também pode retroceder. Os limites, porém, não são os mesmos ao verificados quando uma conta sofre “upgrade”. Uma conta só perde sua categoria “Platinum”, e passa para “Gold”, se o saldo cair abaixo de R$ 100.000,00. A conta só perde a categoria “Gold”, e passa para “Silver”, se o saldo cair para menos de R$ 25.000,00. Note que uma conta nunca perde duas categorias em uma única operação de retirada mesmo que o saldo caia abaixo de R$ 25.000,00. Se ele era “Platinum”, cai para “Gold”. Só poderá cair para “Silver” na próxima operação de retirada. Observação: as contas nunca podem ficar negativas (o banco não trabalha com cheque especial).
Para efeitos de armazenamento no arquivo a categoria “Silver” é identificada com o número “0”, a categoria “Gold” com o número “1” e a categoria “Platinum” com o número “2”.
O número de conta pode ser qualquer inteiro positivo.
