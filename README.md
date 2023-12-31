# PenguinPawPatrol
The Penguin Paw Patrol program will simulate a year in the life of a penguin colony. The simulation progresses month by month, commencing in July and concluding in June, spanning a duration of 12 months. Users have the option to execute the simulation without any Paw Patrol dog protection, with a single Paw Patrol dog, or with two Paw Patrol dogs. In each simulation, the colony initiates with an equal number of penguin families. Upon completion of the simulation, the survival statistics of the penguin colony are presented.

---

## Development Environment
- JDK 17.0.8
- IntelliJ IDEA 2023.2.2


## System Architecture

<img alt="Class Diagram" src="/ClassDiagram.svg" title="Class Diagram" width="900"/>

The abstract class `Animal` is the base class for all animal types. Each `PenguinFamily`, inheriting from this class, consists of two penguins, a specific count of eggs, and a certain number of chicks. 

The penguins, chicks, and eggs are susceptible to predators such as foxes, cats, and sharks. Notably, the Paw Patrol dogs have the capability to eliminate cats and foxes.

An arraylist `AnimalList` is created to store the number of both penguin family and all kinds of predators. At the end of the simulation a summary is displayed and written to the file colonyFinal.txt.

- Family group survival rate:

        (total_penguin_families_with_two_parents / total_penguin_families_at_the_start)) * 100

- Penguin survival rate:

       (total_penguin_alive / total_penguins_at_the_start) * 100

- Egg survival rate:

       (total_eggs_hatched / total_eggs_laid) * 100

- Chick survival rate:

       (total_chicks_alive / total_chicks hatched) * 100

- Overall colony survival:

        (total_penguins_alive + total_chicks_alive) / total_penguins_at_the_start

Note that an overall colony survival < 1 means that the colony will decline and an overall colony survival > 1 means that the colony will grow.

