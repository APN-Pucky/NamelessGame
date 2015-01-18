package namelessgame;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;


public class Player 
{
	private double speed = 40;
	private double mouseSpeed = 1;
	private static Vector3f rotation = new Vector3f(0,0,0);
	private static Vector3f position = new Vector3f(0,0,0);
	
	public Player(double speed, double mousespeed)
	{
		this.speed = speed;
		this.mouseSpeed = mousespeed;
	}
	
	public void changeMatrix()
	{
		 glRotatef(rotation.x, 1, 0, 0);
	     glRotatef(rotation.y, 0, 1, 0);
	     glRotatef(rotation.z, 0, 0, 1);
	     glTranslatef(position.x, position.y, position.z);
	}
	
	public void update(long delta)
	{
		if (Mouse.isGrabbed()) {
            float mouseDX = (float) (Mouse.getDX() * mouseSpeed * 0.16f);
            float mouseDY = (float) (Mouse.getDY() * mouseSpeed * 0.16f);
            if (rotation.y + mouseDX >= 360) {
                rotation.y = rotation.y + mouseDX - 360;
            } else if (rotation.y + mouseDX < 0) {
                rotation.y = 360 - rotation.y + mouseDX;
            } else {
                rotation.y += mouseDX;
            }
            if (rotation.x - mouseDY >= -90 && rotation.x - mouseDY <= 90) {
                rotation.x += -mouseDY;
            } else if (rotation.x - mouseDY < -90) {
                rotation.x = -90;
            } else if (rotation.x - mouseDY > 90) {
                rotation.x = 90;
            }
        }
        
        
        boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
        boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
        boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
        boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
        boolean moveFaster = Keyboard.isKeyDown(Keyboard.KEY_E);
        boolean moveSlower = Keyboard.isKeyDown(Keyboard.KEY_Q);
        if (moveFaster && !moveSlower) {
            speed *= 4f;
        }
        if (moveSlower && !moveFaster) {
            speed /= 10f;
        }
        // If we're pressing the "up" key increase our speed
        if (keyUp && keyRight && !keyLeft && !keyDown) {
            float angle = rotation.y + 45;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyUp && keyLeft && !keyRight && !keyDown) {
            float angle = rotation.y - 45;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyUp && !keyLeft && !keyRight && !keyDown) {
            float angle = rotation.y;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);

            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && keyLeft && !keyRight && !keyUp) {
            float angle = rotation.y - 135;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && keyRight && !keyLeft && !keyUp) {
            float angle = rotation.y + 135;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && !keyUp && !keyLeft && !keyRight) {
            float angle = rotation.y;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) (-(speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyLeft && !keyRight && !keyUp && !keyDown) {
            float angle = rotation.y - 90;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyRight && !keyLeft && !keyUp && !keyDown) {
            float angle = rotation.y + 90;
            Vector3f newPosition = new Vector3f(position);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPosition.z += adjacent;
            newPosition.x -= opposite;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        
        if (flyUp && !flyDown) {
            double newPositionY = (speed * 0.0002) * delta;
            position.y -= newPositionY;
        }
        if (flyDown && !flyUp) {
            double newPositionY = (speed * 0.0002) * delta;
            position.y += newPositionY;
        }
        if (moveFaster && !moveSlower) {
            speed /= 4f;
        }
        if (moveSlower && !moveFaster) {
            speed *= 10f;
        }
	}
}
