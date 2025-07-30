# Calculates the pom version based on the esdl.ecore version
# echo $PWD
V=$(./parse_ecore_version.sh)
echo "Setting pom.xml and Manifest.MF version to $V"
./set_version.sh $V
read
