import java.util.*;

/**
 * The QuizRepository class provides static access to quiz questions for each game level.
 * 
 * It organizes and returns a list of {@code QuizQuestion} objects based on the provided
 * game level. This supports dynamic quiz generation depending on player progression.
 * 
 * Level 1 includes easy, introductory questions.
 * Level 2 introduces moderately harder concepts.
 * Level 3 contains more challenging and advanced questions.
 * 
 * This class centralizes quiz data to keep question logic separate from game world logic.
 * 
 * @author (Theodora Nouni, Anastasia Pourliaka)
 * @version (v1)
 */
public class QuizRepository
{
    public static List<QuizQuestion> getQuestionsForLevel(int level) {
        List<QuizQuestion> questions = new ArrayList<>();

        switch (level) {
            case 1:
                // Level 1: Easy Questions
                questions.add(new QuizQuestion(
                    "What is Newton's 1st Law?",
                    new String[] {
                        "F = ma",
                        "An object stays at rest or moves uniformly unless acted upon",
                        "E = mc^2",
                        "v = d/t"
                    },
                    1
                ));

                questions.add(new QuizQuestion(
                    "Which unit is used to measure force?",
                    new String[] {
                        "Joule",
                        "Watt",
                        "Newton",
                        "Pascal"
                    },
                    2
                ));

                questions.add(new QuizQuestion(
                    "Which of these is NOT a state of matter?",
                    new String[] {
                        "Solid",
                        "Liquid",
                        "Gas",
                        "Energy"
                    },
                    3
                ));

                questions.add(new QuizQuestion(
                    "Which object would fall faster in a vacuum?",
                    new String[] {
                        "A feather",
                        "A rock",
                        "They fall at the same speed",
                        "Neither falls"
                    },
                    2
                ));

                questions.add(new QuizQuestion(
                    "Which one is a source of light?",
                    new String[] {
                        "Mirror",
                        "Sun",
                        "Moon",
                        "Wall"
                    },
                    1
                ));
            
                questions.add(new QuizQuestion(
                    "What tool is used to measure temperature?",
                    new String[] {
                        "Ruler",
                        "Thermometer",
                        "Compass",
                        "Balance"
                    },
                    1
                ));
                
                questions.add(new QuizQuestion(
                    "Water turns into ice at what temperature (Celsius)?",
                    new String[] {
                        "100°C",
                        "0°C",
                        "50°C",
                        "-100°C"
                    },
                    1
                ));

                break;

            case 2:
                // Level 2: Slightly Harder Questions
                questions.add(new QuizQuestion(
                    "What is the formula for kinetic energy?",
                    new String[] {
                        "½mv²",
                        "mg",
                        "mv",
                        "mgh"
                    },
                    0
                ));

                questions.add(new QuizQuestion(
                    "What happens to mass when an object changes location?",
                    new String[] {
                        "It increases",
                        "It decreases",
                        "It stays the same",
                        "It disappears"
                    },
                    2
                ));

                questions.add(new QuizQuestion(
                    "What is the acceleration due to gravity on Earth?",
                    new String[] {
                        "9.8 m/s²",
                        "5.0 m/s²",
                        "100 m/s²",
                        "0 m/s²"
                    },
                    0
                ));

                questions.add(new QuizQuestion(
                    "Which quantity is a vector?",
                    new String[] {
                        "Speed",
                        "Mass",
                        "Velocity",
                        "Time"
                    },
                    2
                ));

                questions.add(new QuizQuestion(
                    "Which of these is a unit of power?",
                    new String[] {
                        "Newton",
                        "Watt",
                        "Joule",
                        "Meter"
                    },
                    1
                ));

                break;
                
            case 3:
                questions.add(new QuizQuestion(
                    "What is the main force that keeps planets in orbit around the sun?",
                    new String[] {
                        "Magnetism",
                        "Friction",
                        "Gravity",
                        "Electricity"
                    },
                        2
                ));

                questions.add(new QuizQuestion(
                    "Which of these materials is a good conductor of electricity?",
                    new String[] {
                        "Plastic",
                        "Wood",
                        "Rubber",
                        "Copper"
                    },
                3
                ));

                questions.add(new QuizQuestion(
                        "Which of the following is NOT an example of potential energy?",
                    new String[] {
                        "A stretched rubber band",
                        "Water at the top of a waterfall",
                        "A moving car",
                        "A compressed spring"
                    },
                    2
                ));

                questions.add(new QuizQuestion(
                        "What is the speed of light in vacuum (approx)?",
                    new String[] {
                        "3,000 km/s",
                        "30,000 km/s",
                        "300,000 km/s",
                        "3,000,000 km/s"
                    },
                     2
                ));

                questions.add(new QuizQuestion(
                    "What simple machine is a seesaw an example of?",
                    new String[] {
                        "Pulley",
                        "Lever",
                        "Wedge",
                        "Wheel and axle"
                    },
                 1
                ));

                questions.add(new QuizQuestion(
                    "Which color of light has the most energy?",
                    new String[] {
                        "Red",
                        "Blue",
                        "Green",
                        "Yellow"
                    },
                1
                ));

                questions.add(new QuizQuestion(
                        "What is sound?",
                        new String[] {
                            "A type of light",
                            "A vibration that travels through a medium",
                            "A form of energy that doesn’t move",
                            "An image in motion"
                        },
                    1
                ));

                questions.add(new QuizQuestion(
                    "What happens to particles when a substance is heated?",
                    new String[] {
                        "They slow down",
                        "They stop moving",
                        "They move faster",
                        "They shrink"
                    },
                2
                ));

                questions.add(new QuizQuestion(
                    "Which gas do humans need to breathe for respiration?",
                    new String[] {
                        "Carbon dioxide",
                        "Oxygen",
                        "Nitrogen",
                        "Helium"
                    },
                    1
                ));

                questions.add(new QuizQuestion(
                    "Which physical quantity is measured in amperes?",
                    new String[] {
                        "Voltage",
                        "Resistance",
                        "Current",
                        "Power"
                    },
                    2
                ));

                break;
        }

        return questions;
    }
}