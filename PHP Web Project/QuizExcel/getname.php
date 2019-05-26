<?php

    include("accessdb.php");

    $fname = $_POST['fname'];
    $numque = $_POST['numque'];
    $topic = $_POST['Topic'];

	$query = "SELECT * FROM players WHERE player_name = '$fname' "; 
    $result = $conn->query($query) or die($conn->error);
    
    $query1 = "SELECT * FROM questionanswer WHERE topic = '$topic' LIMIT $numque "; 
    $result1 = $conn->query($query1) or die($conn->error);

    $question = [];
    $answer = [];

    while ($row = $result1->fetch_assoc()) {
        $question[] = $row['question'];
        $answer[] = $row['answer'];
    }

    $question_json_array = json_encode($question);
    
    $answer_json_array = json_encode($answer);

    $questionlength = count($question);

?> 

<!DOCTYPE html>
<html>
<head>
	<title>Quiz</title>
	<link rel="stylesheet" type="text/css" href="./css/style2.css">
</head>
<body>
    <div id="content">
        <h1>Quiz</h1>
        <div class="quiz-container">
            <div id="quiz"></div>
        </div>
    
        <button id="previous">Previous Question</button>
        <button id="next">Next Question</button>
        <button id="review">Review Quiz</button>
        <br>
        <br>
        <br>
        <br>
    </div>
    
    <div id="reviewContainer">
        <h1>Reviewer</h1>
        <ol id="list"></ol>
        <br>
        <br>
        <button id='back'>Back to Quiz</button>
        <button id='submit'>Submit Quiz</button>
        <br>
        <br>
        <div id="results"></div>
    </div>
    <script>
        (function() {
            const myQuestions = JSON.parse('<?= $question_json_array; ?>');
            
            const CorrectAnswers = JSON.parse('<?= $answer_json_array; ?>');
            var useranswer = [];
            document.getElementById("reviewContainer").style.visibility="hidden";

            function buildQuiz() {
                const output = [];
                myQuestions.forEach((currentQuestion, questionNumber) => {
                
                output.push(
                    `<div class="slide">
                    <div class="question"> ${currentQuestion} </div>
                    <div class="answer"> <input type="text" name="answer" class="textf"></div>
                    </div>`
                );
                });
                quizContainer.innerHTML = output.join("");
            }
            function showResults() {
                
                var score = 0;
                for ( let x = 0 ; x < myQuestions.length ; x++ ){
                    let answer = document.getElementsByClassName("textf")[x].value;
                    useranswer.push(answer);
                }
                for ( let x = 0 ; x < myQuestions.length ; x++){
                    if(useranswer[x] === CorrectAnswers[x]){
                        score++;
                    }
                }
                resultsContainer.innerHTML = `${score} out of ${myQuestions.length}`;
            }
            function showReview(){
                for ( let x = 0 ; x < myQuestions.length ; x++ ){
                    let answer = document.getElementsByClassName("textf")[x].value;
                    useranswer[x] = answer;
                }
                for ( let x = 0 ; x < myQuestions.length ; x++ ){
                    document.getElementsByClassName("textf")[x].value = useranswer[x];
                }
                document.getElementById("content").style.visibility="hidden";
                document.getElementById("reviewContainer").style.visibility="visible";
                var reviewContainer = document.getElementById("reviewContainer");
                var qlist = document.getElementById("list");
                var br, li;
                if(document.getElementById("qlist") == null){
                    for( let x = 0; x < myQuestions.length ; x ++){
                        li = document.createElement('LI');
                        var question = document.createTextNode("Question : " + myQuestions[x]);
                        var answer = document.createTextNode("Answer : " + useranswer[x]);
                        li.appendChild(question);
                        li.appendChild(answer);
                        qlist.append(li);
                        br = document.createElement('br');
                        qlist.prepend(br);
                    }
                }
                submitButton.style.display = "visible";
            }
            function showSlide(n) {
                slides[currentSlide].classList.remove("active-slide");
                slides[n].classList.add("active-slide");
                currentSlide = n;
                
                if (currentSlide === 0) {
                previousButton.style.display = "none";
                } else {
                previousButton.style.display = "inline-block";
                }
                
                if (currentSlide === slides.length - 1) {
                nextButton.style.display = "none";
                ReviewButton.style.display = "inline-block";
                } else {
                nextButton.style.display = "inline-block";
                ReviewButton.style.display = "none";
                }
            }
            function showNextSlide() {
                showSlide(currentSlide + 1);
            }
            function showPreviousSlide() {
                showSlide(currentSlide - 1);
            }
            function back(){
                document.getElementById("content").style.visibility="visible";
                document.getElementById("reviewContainer").style.visibility="hidden";
                document.getElementById("list").innerHTML = "";
            }

            const quizContainer = document.getElementById("quiz");
            const resultsContainer = document.getElementById("results");
            const ReviewButton = document.getElementById("review");
            const submitButton = document.getElementById("submit");
            const BackButton = document.getElementById("back");
            buildQuiz();
            const previousButton = document.getElementById("previous");
            const nextButton = document.getElementById("next");
            const slides = document.querySelectorAll(".slide");
            let currentSlide = 0;
            showSlide(0);
            BackButton.addEventListener("click", back);
            submitButton.addEventListener("click", showResults);
            ReviewButton.addEventListener("click", showReview);
            previousButton.addEventListener("click", showPreviousSlide);
            nextButton.addEventListener("click", showNextSlide);
        })();
    </script>
</html>