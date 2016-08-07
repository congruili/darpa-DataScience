# darpa-FacetedBrowser
DARPA data Faceted Search using ElasticSearch

## programs required
1. Version 1.7.0 of ElasticSearch was used. It is available [here](https://www.elastic.co/downloads/past-releases/elasticsearch-1-7-0).

2. Front end for ElasticSearch search indices:
https://github.com/CottageLabs/facetview2

3. Another web front end for an Elasticsearch cluster (for Elasticsearch 1.x):
https://github.com/mobz/elasticsearch-head

## transform data from CSV to JSON
After compiling CSVtoJSON.java, execute the CSVtoJSON.class file with the following arguments:
```
$ java CSVtoJSON [name of the original csv file] [name of the json file to be generated]
```

## load the data into ElasticSearch cluster:
0. create a new index named darpa: 
   
   `$ curl -XPUT 'localhost:9200/darpa?pretty'`
1. load the mapping file to index name "darpa" and type name "doe": 
   
   `$ curl -XPUT 'http://localhost:9200/darpa/doe/_mapping' --data-binary "@mapping.json"`
2. load the dataset into ElasticSearch cluster:
   
   `$ curl -XPOST 'localhost:9200/darpa/doe/_bulk?pretty' --data-binary "@[name of the json file]"`

