Am facut un model de masina care are: id, nuame, model, price, year, enginePower si type.
Pentru acest model am facut si un Dto care are doar name si type.
Am facut un Dto si pentru DarkMode unde am daor un boolean darkMode.
Tot ca Dto am si GetCarResponseDto pe care l-am facut pentru a avea output-ul ca in modelul dat de tine.
In aceasta clasa am un boolean darkMode si o lista de CarDto.
In controller am 4 endpoint-uri:
	- getAllCars care afiseaza darkMode si lista de masini
	- addCar care adauga o masina
	- changeMode care schimba darkMode-ul din cookie
	- invalidateCookie care imi invalideaza un cookie (pune maxAge pe 0)
O sa las si un import pentru request-urile de Postman.
Pentru a testa invalidateCookie se poate vedea doar in headers ca se modifica, pt
ca Postman tine minte toate cookie-urile atata timp cat nu e incheiata sesiunea, din
cauza modului in care face manage.
