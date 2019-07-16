# Wild Shape Helper
A helper for D&amp;D 5e Druid wild shape

For example of beast file layout to add more or modify existing, please see defaultEntry.json.
The following fields are required, all others may be omitted:
* name
* cr
* size
* hp
* ac
* strength
* dexterity
* constitution
* intelligence
* wisdom
* charisma

# Running locally
```
Navigate to directory 'wildShapeHelper/main'
run 'mvn clean install tomcat7:exec-war-only'
run 'java -jar target/wildShapeHelper-1.0-SNAPSHOT-war-exec.jar'
go to 'http://localhost:8080/wildShapeHelper/index.html' in a browser
```

I do not own any of the contained beasts or descriptions. I used https://roll20.net/compendium/dnd5e/Monsters%20List#content to get a compiled list of 5e beasts.
Habitat descriptions used are from https://www.dandwiki.com/wiki/SRD:Creatures_by_Environment or based on habitats of the real creatures
