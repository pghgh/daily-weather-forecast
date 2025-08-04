import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {DisplayWeatherService} from "./display-weather.service";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';

/*
TAKEN FROM 1
The code for sending a HTTP request was taken from:
https://medium.com/@srishti.srajput/http-protocol-angular-18-typescript-46e8ae9f25e2
*/

/*
TAKEN FROM 2
The code for using Angular reactive forms was taken from:
https://www.digitalocean.com/community/tutorials/angular-reactive-forms-introduction
 */

@Component({
	selector: 'app-root',
	imports: [RouterOutlet, ReactiveFormsModule],
	templateUrl: './app.component.html',
	standalone: true,
	styleUrl: './app.component.scss'
})
export class AppComponent {

	title = 'daily-weather-forecast-frontend';
	cityName = 'Vienna'
	temperature = 0
	hour = 0
	// TAKEN FROM START 2
	myForm: FormGroup;

	constructor(private displayWeatherService: DisplayWeatherService, private fb: FormBuilder) {
		this.myForm = new FormGroup({})
	}

	ngOnInit() {
		this.myForm = this.fb.group({
			cityNameInput: ['Vienna', Validators.required],
		});
	}

	onSubmit(form: FormGroup) {
		console.log('Valid?', form.valid); // true or false
		console.log('Name', form.value.cityNameInput);
		this.getWeatherInformation(form.value.cityNameInput);
	}
	// TAKEN FROM END 2

	// TAKEN FROM START 1
	getWeatherInformation(city: string) {

		this.displayWeatherService.getWeatherInfo(city).subscribe((response) => {
			console.log('response:', response);
			this.cityName = response.cityName
			this.hour = response.hour
			this.temperature = response.temperature
		});


	}
	// TAKEN FROM END 1
}
