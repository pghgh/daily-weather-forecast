import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {DisplayWeatherService} from "./display-weather.service";

/*
TAKEN FROM 1
The code for sending a HTTP request was taken from:
https://medium.com/@srishti.srajput/http-protocol-angular-18-typescript-46e8ae9f25e2
*/

@Component({
	selector: 'app-root',
	imports: [RouterOutlet],
	templateUrl: './app.component.html',
	standalone: true,
	styleUrl: './app.component.scss'
})
export class AppComponent {

	title = 'daily-weather-forecast-frontend';

	constructor(private displayWeatherService: DisplayWeatherService) {
	}

	// TAKEN FROM START 1
	getWeatherInformation() {
		this.displayWeatherService.getWeatherInfo().subscribe((response) => {
			console.log('response:', response);
		});
	}
	// TAKEN FROM END 1
}
