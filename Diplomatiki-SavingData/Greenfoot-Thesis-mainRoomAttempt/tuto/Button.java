import greenfoot.*;


/**
 * Something you can click on, and it will send messages to it's responder.
 * 
 * @author Sven van Nigtevecht
 * @Modifications Margarita Tryfou
 * @version 1.0
 */
public class Button extends Actor
{
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR2 = Color.BLACK;
    private GreenfootImage backgroundImage;

    private String title;
    private ButtonResponder responder;

    /**
     * Constructor for objects of the class Button, with no title:
     * only the image.
     */
    public Button()
    {
        this("");
    }

    /**
     * Constructor for objects of the class Button with a title.
     */
    public Button(String title)
    {
        this.title = title;
        createBackgroundImage();
        refreshImage();
    }

    /**
     * Constructor for objects of the class Button with a title and given color.
     */
    public Button(String title, int r, int g, int b)
    {
        this.title = title;
        createBackgroundImage(r,g,b);
        refreshImage(35);
    }

    /**
     * Constructor for objects of the class Button with a transparent background and specific x,y
     */
    public Button(int x, int y)
    {
        createBackgroundImage(x, y);
        title = "afdg";
        refreshImage(30);
    }

    //general buttons
    private void createBackgroundImage()
    {
        GreenfootImage img = new GreenfootImage(100, 50);
        img.setColor(Color.BLACK);
        img.fill();
        img.setColor(new Color(0, 200, 255, 180));
        img.fillRect(4, 4, img.getWidth() - 8, img.getHeight() - 8);
        img.setTransparency(200);

        this.backgroundImage = img;
        setImage(this.backgroundImage);
    }

    //transparent buttons
    private void createBackgroundImage(int x, int y)
    {
        GreenfootImage img = new GreenfootImage(x, y);
        img.setColor(Color.BLACK);
        img.fill();
        img.setTransparency(50);
        this.backgroundImage = img;
        setImage(this.backgroundImage);
    }

    //creates a button at specific color
    private void createBackgroundImage(int r, int g, int b)
    {
        GreenfootImage img = new GreenfootImage(200, 50);
        img.setColor(Color.ORANGE);
        img.fill();
        img.setColor(new Color(r, g, b));
        img.fillRect(4, 4, img.getWidth() - 8, img.getHeight() - 8);
        //img.setTransparency(250);

        this.backgroundImage = img;
        setImage(this.backgroundImage);
    }

    //general button creation
    private void refreshImage()
    {
        GreenfootImage backgroundImage = new GreenfootImage(this.backgroundImage);
        GreenfootImage text = new GreenfootImage(title, 22, TEXT_COLOR, new Color(0,0,0,0));

        if (text.getWidth() > backgroundImage.getWidth() - 20) {
            backgroundImage.scale(text.getWidth() + 20, backgroundImage.getHeight());
        }

        int x = (backgroundImage.getWidth() -text.getWidth() ) /2;
        int y = (backgroundImage.getHeight() -text.getHeight() ) /2;
        backgroundImage.drawImage(text, x, y);
        setImage(backgroundImage);
    }

    //quiz button creation
    private void refreshImage(int height)
    {
        GreenfootImage backgroundImage = new GreenfootImage(this.backgroundImage);
        GreenfootImage text = new GreenfootImage(title, height, TEXT_COLOR2, new Color(0,0,0,0));

        if (text.getWidth() > backgroundImage.getWidth() - 20) {
            backgroundImage.scale(text.getWidth() + 20, backgroundImage.getHeight());
        }

        int x = (backgroundImage.getWidth() -text.getWidth() ) /2;
        int y = (backgroundImage.getHeight() -text.getHeight() ) /2;
        backgroundImage.drawImage(text, x, y);
        setImage(backgroundImage);
    }

    /**
     * Sets the responder of the button.
     */
    public void setResponder(ButtonResponder responder)
    {
        if (this.responder != responder) {
            this.responder = responder;
        }
    }

    /**
     * Returns the responder of the button.
     */
    public ButtonResponder getResponder()
    {
        return this.responder;
    }

    /**
     * Returns the title of the button.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title of the button.
     */
    public void setTitle(String newTitle)
    {
        if (!this.title.equals(newTitle)) {
            this.title = newTitle;
            refreshImage();
        }
    }

    public void setTitleB(String newTitle)
    {
        if (!this.title.equals(newTitle)) {
            this.title = newTitle;
            refreshImage(35);
        }
    }

    /**
     * Check for clicks on the button, and send messages to the responder.
     * It also takes care of updating the image when you move over the button
     * with your mouse.
     */
    public void act() 
    {
        if (this.responder != null) {
            if (Greenfoot.mouseClicked(this)) {
                this.responder.buttonClicked(this);
            }
        }
    }
}