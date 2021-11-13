# Spring-kalkulator-spanca
Preprost API za preračunavanje začetne ure spanca, glede na želeno uro zbujanja.

Primer:
```bash
$ curl http://localhost:8080/wakeup/0800
{"currentTime":"2021-11-13T18:31:20.5729154","sleepStart":"2021-11-14T00:30:20.5729154","duration":"PT7H30M"}
```
