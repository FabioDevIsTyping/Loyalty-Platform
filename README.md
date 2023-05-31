

# Loyalty Platform IdS De Vitis - Caggiano

![Logo](https://s3.envato.com/files/269204463/loyalty-platform_inline_preview.jpg)

L’idea di questo progetto è aiutare tutte le attività ad incrementare il tasso di fidelizzazione,ritenere i clienti e acquisirne di nuovi.
La probabilità di vendere a un cliente esistente è compresa tra il 60% e il 70%, mentre a un potenziale nuovo cliente solo tra il 5% e il 20%.
Il target di riferimento sono attività locali con +2 stabilimenti.

Gli obiettivi principali sono:
- Aumentare il fatturato
- Ritenere i clienti
- Ottenere nuovi clienti grazie a quelli esistenti
- Costruire un Database qualificato

## FAQ

#### Chi interagisce con la piattaforma?

I soggetti principali che interagiranno con la piattaforma sono i seguenti:
1) Clienti.
2) Titolari dell'azienda che si vuole iscrivere alla Loyalty Platform.
3) Amministratori del punto vendita x dell'azienda y.
4) Dipendenti del punto vendita x.
#### Qual'è l'idea per fidelizzare il cliente?
L'azienda che si iscrive alla loyalty platform potrà effettuare una
fidelizzazione dei propri clienti attraverso l'adozione di uno dei programmi fedeltà offerti dalla piattaforma. L'azienda potrà infatti scegliere se sottoscrivere uno dei seguenti programmi:
1) Programma a punti
2) Programma a livelli
3) Programma membership esclusiva o VIP
4) Programma Cashback
5) Programma coalizione
#### Cosa caratterizza un programma a punti?
Un programma a punti è caratterizzato dall'introduzione di un 
sistema a punti che premierà il cliente in base all'importo degli acquisti compiuti all'interno dei punti vendita dell'azienda che adottano tale programma. Infatti più un cliente spenderà all'interno del negozio dell'azienda più punti egli accumulerà e di conseguenza potrà scegliere se spendere questi punti e scegliere dei premi presenti nel catalogo premi oppure continuare ad accumulare i suddetti punti.
#### Cosa caratterizza un programma a livelli?
Un programma a livelli è molto simile ad un programma a punti. Difatti più un cliente acquisterà all'interno del negozio più punti esperienza questo cliente otterrà. Tuttavia i punti esperienza servono per ottenere un nuovo livello di esperienza che offrirà al cliente degli sconti su determinati prodotti. Più il livello sarà alto più gli sconti saranno vantaggiosi.
#### Cosa caratterizza un programma VIP?
Un programma VIP è un programma a cui il cliente può aderire pagando un certo ammontare di denaro per ottenere una carta VIP. Questa carta fornirà sempre degli sconti al cliente che saranno molto vantaggiosi rispetto all'ammontare di denaro speso per la carta.
#### Cosa caratterizza un programma Cashback?
Un programma cashback utilizza il cashback per cercare di fidelizzare il cliente. Il cliente infatti compiendo acquisti all'interno del punto vendita riuscirà ad ottenere una piccola percentuale della spesa in cashback, per esempio se si spenderanno 100 euro all'interno del negozio si otterrà un cashback. Il rimborso è pari al 10% dell'importo di ogni transazione ed è calcolato sulla base del valore complessivo delle transazioni effettuate durante il Periodo di riferimento e rilevanti ai fini del Programmma. 
#### Cosa caratterizza una coalizione?
La coalizione è una specie di accordo tra aziende che fanno parte della Loyalty platform, per fidelizzare i propri clienti queste aziende forniscono sconti reciproci su determinati articoli.
#### Come posso io cliente sfruttare dei vantaggi del programma fedeltà?
Il cliente può accedere ai vantaggi del programma fedeltà sottoscrivendo il modulo di adesione presso uno dei punti vendita aderenti alla loyalty platform. Vi verrà poi attribuita una carta fedeltà contenente tutte le informazioni e i vari dati riguardanti essa. (Esempio: numero di punti posseduti, sconti, vantaggi, cashback ecc).
#### Come posso accedere alle informazioni sulle mie carte fedeltà?
Il cliente può accedere alle informazioni su tutte le proprie carte fedeltà all'interno della propria area riservata. Infatti vi è presente un portafoglio che è collegato univocamente ad un cliente e racchiude tutte le carte fedeltà del cliente con tutti i dati relativi ad esse. 




## Documentation

[Documentation](https://github.com/FabioDevIsTyping/IdS-2022-DeVitis-Caggiano)




## API Reference


#### Clienti

- Inserisce un cliente all'interno della piattaforma.
```http
  POST /localhost:8080/insertClient
```

- Ritorna la lista di tutti i clienti della piattaforma.

```http
  GET /localhost:8080/getClienti
```

- Ritorna la lista di tutti i clienti di un determinato punto vendita con id x.

```http
  GET localhost:8080/getClienti/{id}
```
- Cancella un determinato cliente dalla piattaforma dato l'id del cliente da cancellare.
```http
  DELETE localhost:8080/deleteCliente/{id}
```
#### Admin

- Inserisce un admin all'interno della piattaforma.
```http
  POST /localhost:8080/insertClient
```
- Ritorna la lista di tutti gli admin presenti nella piattaforma.

```http
  GET /localhost:8080/getAdmins 
```
- Cancella un determinato admin dalla piattaforma dato l'id dell' admin da cancellare.
```http
  DELETE localhost:8080/deleteAdmin/{id}
```
#### Dipendente

- Inserisce un dipendente all'interno della piattaforma.
```http
  POST /localhost:8080/insertDipendente
```
- Cambia un dipendente e lo fa diventare admin presso il punto vendita del quale era dipendente.
```http
  POST /localhost:8080/changeDipendenteToAdmin
```

- Ritorna la lista di tutti i dipendenti presenti nella piattaforma.

```http
  GET /localhost:8080/getDipendenti
```

- Ritorna la lista di tutti i dipendenti presenti nella piattaforma di un punto vendita x, dato l'id di questo punto vendita.

```http
  GET /localhost:8080/getDipendentiByPuntoVenditaId/{id}
```
- Cancella un determinato dipendente dalla piattaforma dato l'id del dipendente da cancellare.
```http
  DELETE localhost:8080/deleteDipendente/{id}
```
#### Titolare Azienda
- Inserisce un titolare azienda all'interno della piattaforma.
```http
  POST /localhost:8080/insertTitolareAzienda
```
- Ritorna la lista di tutti i titolari azienda presenti nella piattaforma.

```http
  GET /localhost:8080/getTitolareAzienda
```
- Cancella un determinato titolare azienda dalla piattaforma dato l'id del titolare azienda da cancellare.
```http
  DELETE localhost:8080/deleteTitolareAzienda/{id}
```
- Ritorna la lista di tutti i dipendenti presenti in uno dei suoi punti vendita.

```http
  GET /localhost:8080/getListaDipendenti
```
- Vede la lista dei programmi fedeltà disponibili.
```http
  GET /localhost:8080/getListaDipendenti
```
## Authors

- [@Fabio De Vitis Michele](https://github.com/FabioDevIsTyping)
- [@Matteo Caggiano](https://github.com/caggicaggi)

