/**
 * Represents a quiz question with multiple answer choices.
 * Stores the question text, answer options, and the index of the correct answer.
 * Used during the quiz phase of the game.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class QuizQuestion  
{
    private String question;
    private String[] options;
    private int correctIndex;
    
    public QuizQuestion(String question, String[] options, int correctIndex)
    {
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public String getQuestion() { 
        return question; 
    }
    
    public String[] getOptions() { 
        return options; 
    }
    
    public int getCorrectIndex() { 
        return correctIndex; 
    }
}
