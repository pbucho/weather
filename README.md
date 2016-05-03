# Weather

* Collects weather forecast information present in the IPMA website and compiles it into a database.

## Requirements

* The information is collected via a shell script to a html file in the file system for archival.
* 5 minutes after the page retrieval, the Java application should retrieve the saved html file.
* The application will extract the ``<table>`` tag identified by ``id="tab_meteo"``
* The application will then collect the following information:
	* Minimum atmospheric temperature
	* Maximum atmospheric temperature
	* Weather state
	* Precipitation probability
	* Wind state
	* Ultraviolet index
	* Weather alerts
This information will be saved into a POJO.
* The information contained in the POJO will then be persisted into the database.