# Steps to Release an new ESDL version


## Release new version of the Ecore file and associated Java code
When editing the ESDL.ecore file in Eclipse do the following:
- set the version annotation of the ESDL Ecore package in the `esdl.ecore` file to vYYMM where YY is the year (e.g. 20*21*) and MM the month (e.g. 11 for November).

   
Then on the unix/bash command line do:
- run `update_pom_version_from_esdl_ecore_version.sh` to convert the vyyMM (e.g. v2109) version number to the ESDL Java jar version (2.yy.MM)
- this script requires unix the tools `grep` and `sed`, plus the `mvn` command line tool to update the pom.xml and Manifest.MF files.
	- alternative is to run the Eclipse Run Configuration `Set pom.xml version manually.launch` in the esdl.parent folder. Go to the 'Run -> Run Configurations' in Eclipse, under `Maven Build` this configuration should show up. Update the `newVersion` parameter to the correct ESDL version (so e.g. `2.21.11`) and run this configuration. This will update both pom.xml and Manifest.MF versions to match this ESDL version (assuming they are in sync).
- git commit
- git push to github
- for completeness git tag this release with the version number `git tag v2109 -m 'New ESDL release'`


## pyESDL
- update esdl using `updateESDL.bat` (this downloads the latest ESDL version from github)
- update README.md with changes
- git commit && git push
- git tag 21.9.1 -m "commit message"
- git push --tags
- CI pipeline triggers on new tag and releases to pypi

## ESDL documentation site (see also the README of esdl-docgen project)
- git pull energytransition.github.io (to get the latest version of the doc site, if not there yet. Otherwise too much conflicts...)
- make sure  PLANTUML_LIMIT_SIZE is set in your environmental variables (e.g. to 20000)
- java -jar target/esdl-docgen-1.0-jar-with-dependencies.jar
- cd energytransition.github.io
- git commit -a -m "New release ESDL version 2xyy"
- git push

## ESDL Drive
- create CDO-based jars for ESDL using the `cdo` maven profile in esdl.parent and install this in the (local) maven repo.
- mvn clean install -P cdo
- Update the pom.xml of CDO-Server project and ESDL-drive project to use the new version of the packages
- build both docker containers, push them to docker Hub and redeploy
- restart the CDO-Server container again, as in the first run it will migrate the database automatically and does not always restart correctly. Restarting helps here.

- 