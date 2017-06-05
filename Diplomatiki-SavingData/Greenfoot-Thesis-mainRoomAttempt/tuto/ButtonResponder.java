/**
 * Implement this to respond to the actions of a button.
 * 
 * @author Sven van Nigtevecht
 * @version 1.0
 */
public interface ButtonResponder
{
    /**
     * This gets called on you when the button you are the responder
     * of is clicked.
     * @param button The button which is clicked and sends you this message.
     */
    public void buttonClicked(Button button);
}
