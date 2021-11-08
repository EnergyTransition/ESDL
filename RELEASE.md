Eclipse
- set annoation version to v2x0y
- update documentation to version

# OLD: 
   - set pom.xml of esdl, esdl.parent, esdl.edit, esdl.editor, esdl.buildtools to 2.2x.y, no zero before y (e.g 09 is wrong) 
     as eclipse version numbering does not accept this
# NEW:
	- run `update_pom_version_from_esdl_ecore_version.sh` to convert the vyyxx (e.g. v2109) version number to the ESDL Java jar version (2.yy.xx)
	- this script requires unix the tools `grep` and `sed`, plus the `mvn` command line tool to update the pom.xml and Manifest.MF files.
	- 
- push esdl
- for completeness git tag to 


pyESDL
- update esdl using updateESDL.bat
- update README.md with changes
- git commit && git push
- git tag 21.9.1 -m "commit message"
- git push --tags
- CI pipeline triggers on new tag and releases to pypi

ESDL documentation site
- git pull energytransition.
- java -jar ...
- cd energytransition.github.io
- git commit -a -m "New release ESDL version 2xyy"
- git push