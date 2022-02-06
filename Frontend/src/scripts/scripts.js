const HIDDEN = 'hidden';
const WARNING = 'warning';
const INPUT = 'input';
const SELECT = 'select';

const button = document.querySelector('.main--button');
const valueInput = document.querySelector('.input--container__input');
const unitSelect = document.querySelector('.input-units--select');
const inputError = document.querySelector('.input--container__error');
const resultContainer = document.querySelector('.main--result__container');
const resultText = document.querySelector('.main--result');
const resultValue = document.querySelector('.main--result__value');
const resultLoader = document.querySelector('.main--result__loader');

const validateFields = () => {
    const value = valueInput.value;
    const option = unitSelect.value; 
    
    let areFieldsValid = false;

    // Input
    if (value.length === 0) {
        valueInput.classList.add(WARNING);
    } else {
        valueInput.classList.remove(WARNING);
    }

    // Select
    if (option < 0) {
        unitSelect.classList.add(WARNING);
    } else {
        unitSelect.classList.remove(WARNING);
    }

    // Error label
    if (value.length === 0 || option < 0) {
        inputError.classList.remove(HIDDEN);
        resultContainer.classList.add(HIDDEN);
    } else {
        inputError.classList.add(HIDDEN);
        areFieldsValid = true;
    }

    return areFieldsValid;

}

const sendRequest = async () => {
    const areFieldsValid = validateFields();

    if (areFieldsValid) {
        // 0: Celsius || 1: Fahrenheit
        const unit = unitSelect.value === '0' ? 'celsius' : 'fahrenheit';
        const value = valueInput.value;

        // Dev url
        // const url = `http://localhost:4567/api/v1/${unit}?value=${value}`;

        // Prod
        const url = `https://lab-01-arep-back.herokuapp.com/api/v1/${unit}?value=${value}`;

        try {
            // Show loader
            resultContainer.classList.remove(HIDDEN);
            resultLoader.classList.remove(HIDDEN);
            resultText.classList.add(HIDDEN); 

            const response = await fetch(url, {
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json'
                }
            });
    
            const data = await response.json();

            if (data) {
                resultText.classList.remove(HIDDEN); 

                resultValue.innerHTML = `${data?.result} grados ${data?.units?.toLowerCase()}`
            }

        } catch(err) {
            console.error(err.message);

        } finally {
            resultLoader.classList.add(HIDDEN);
        }
        
    }
}


button.addEventListener('click', sendRequest);