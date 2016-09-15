# Process and Step Triple Generator

`ProcessAndStepTripleGenerator` is the main class. 

**Usage:**

After compiling `.java` files, execute the `ProcessAndStepTripleGenerator.class` file with the following arguments:
```
$ java ProcessAndStepTripleGenerator [total number of process loops] 
                                     [total number of steps in each process]
                                     [name of the process]
                                     [name of the first step in each process]
                                     [name of the second step in each process]
                                     ......
                                     [name of the last step in each process]
                                     [name of the output file]

Please include the namespace(e.g. "ampo:") and "_" in all process and step names,
such as "ampo:wire_feeding".
```

Sample arguments used for the EBeam use case:

$ java ProcessAndStepTripleGenerator `20` `3` `ampo:ebeam_loop` `ampo:wire_feeding` `ampo:preheat` `ampo:laser_scanning` `output.ttl`

Please check out the sample output file `output.ttl` for this use case. 
