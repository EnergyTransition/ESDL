# convert esdl version in ecore file (e.g. v2101) to maven version (e.g. 2.21.1) such that it removes the 0 before the 1 in the month
ECORE_FILE="../esdl/model/esdl.ecore"
ECORE_VERSION=$(cat "$ECORE_FILE" | grep "http://www.tno.nl/esdl/version" -A 2 | grep "<details key=\"version\"")
if [ -z "$ECORE_VERSION" ]; then 
	echo "Can't find ESDL version in esdl.ecore at $ECORE_FILE"; 
	exit 1
fi
POM_VERSION=$(echo $ECORE_VERSION | sed 's/.*value="v\([0-9][0-9]\)\([0-9][0-9]\)".*/2.\1.\2/' | sed 's/\(.*\)\0\([0-9]\)\(.*\)/\1\2\3/')
echo $POM_VERSION
