'use strict';

let secretNumber = Math.trunc(Math.random() * 20) + 1;
let highscore = Number(document.querySelector('.highscore').textContent);

const displayMessage = function(message) {
    document.querySelector('.message').textContent = message;
};

document.querySelector('.check').addEventListener('click', function() {
    const guess = Number(document.querySelector('.guess').value);
    let score = Number(document.querySelector('.score').textContent);

    console.log(guess);

    // When there is no input
    if (!guess) {
        document.querySelector('.message').textContent = '🚫 No Number';

        // When player wins
    } else if (guess === secretNumber) {
        displayMessage('🎉 Correct Number!');
        document.querySelector('.number').textContent = secretNumber;
        // Changes background color and width of text when player wins
        document.querySelector('body').style.backgroundColor = '#60b347';
        document.querySelector('.number').style.width = '30rem';

        if (score > highscore) highscore = score;

        // When guess is too high
    } else if (score > 1) {
        if (guess > secretNumber) {
            displayMessage('Number is too high!');
            score--;

            // When guess is too low
        } else {
            displayMessage('Number is too low!');
            score--;
        }

        // When player loses
    } else {
        displayMessage('You lost the game!');
        score = 0;
    }

    // Update score at end of every round
    document.querySelector('.score').textContent = score;
    document.querySelector('.highscore').textContent = highscore;
});

document.querySelector('.again').addEventListener('click', function() {
    document.querySelector('.score').textContent = '20';
    document.querySelector('body').style.backgroundColor = '#222';
    document.querySelector('.number').style.width = '15rem';
    secretNumber = Math.trunc(Math.random() * 20) + 1;
    displayMessage('Start guessing...');
    document.querySelector('.number').textContent = '?';
    document.querySelector('.guess').value = '';
});