import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {WeatherDto} from "./weather.dto";
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';

/*
TAKEN FROM 1
The code for sending a HTTP request was taken from:
https://medium.com/@srishti.srajput/http-protocol-angular-18-typescript-46e8ae9f25e2


TAKEN FROM 2
The solution of casting the answer of the HTTP GET request to the used DTO was taken from:
https://stackoverflow.com/a/48837719
*/

@Injectable({
	providedIn: 'root'
})
export class DisplayWeatherService {

    // TAKEN FROM START 1
	baseUrl = 'http://localhost:8080/api/v1/daily-weather-forecast/temperature';

	constructor(private http: HttpClient) {
	}

	getWeatherInfo(city: string): Observable<WeatherDto> {
		// TAKEN FROM START 2
		return this.http.post<WeatherDto>(`${this.baseUrl}?cityName=${city}`, city).pipe(
			catchError((error) => {
				console.error('Error fetching user:', error);
				return throwError(error);
			})
		);
		// TAKEN FROM END 2
	}
	// TAKEN FROM END 1
}
