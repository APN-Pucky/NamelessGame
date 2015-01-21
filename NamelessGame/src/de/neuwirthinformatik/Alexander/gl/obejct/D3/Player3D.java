package de.neuwirthinformatik.Alexander.gl.obejct.D3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.PlayerGL;


public class Player3D extends Object3D
{
	private double speed = 40;
	private double mouseSpeed = 1;
	//private static Vector3f rotation = new Vector3f(0,0,0);
	//												data[3],data[4],data[5]
	//private static Vector3f position = new Vector3f(0,0,0);
	//												data[0],data[1],data[2]
	public Player3D(double speed, double mousespeed)
	{
		this.speed = speed;
		this.mouseSpeed = mousespeed;
	}
	
	public void update(long delta)
	{
		if (Mouse.isGrabbed()) {
            float mouseDX = (float) (Mouse.getDX() * mouseSpeed * 0.16f);
            float mouseDY = (float) (Mouse.getDY() * mouseSpeed * 0.16f);
            if (data[4] + mouseDX >= 360) {
                data[4] = data[4] + mouseDX - 360;
            } else if (data[4] + mouseDX < 0) {
                data[4] = 360 - data[4] + mouseDX;
            } else {
                data[4] += mouseDX;
            }
            if (data[3] - mouseDY >= -90 && data[3] - mouseDY <= 90) {
                data[3] += -mouseDY;
            } else if (data[3] - mouseDY < -90) {
                data[3] = -90;
            } else if (data[3] - mouseDY > 90) {
                data[3] = 90;
            }
        }
        
		
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))GLGlobal.stop();
        
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
        
        if (keyUp && keyRight && !keyLeft && !keyDown) {
            float angle = data[4] + 45;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyUp && keyLeft && !keyRight && !keyDown) {
            float angle = data[4] - 45;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyUp && !keyLeft && !keyRight && !keyDown) {
            float angle = data[4];
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);

            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyDown && keyLeft && !keyRight && !keyUp) {
            float angle = data[4] - 135;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyDown && keyRight && !keyLeft && !keyUp) {
            float angle = data[4] + 135;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyDown && !keyUp && !keyLeft && !keyRight) {
            float angle = data[4];
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) (-(speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyLeft && !keyRight && !keyUp && !keyDown) {
            float angle = data[4] - 90;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        if (keyRight && !keyLeft && !keyUp && !keyDown) {
            float angle = data[4] + 90;
            Vector3f newPos = new Vector3f(data[0],data[1],data[2]);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            data[2] = newPos.z;
            data[0] = newPos.x;
        }
        
        if (flyUp && !flyDown) {
            double newPosY = (speed * 0.0002) * delta;
            data[1] -= newPosY;
        }
        if (flyDown && !flyUp) {
            double newPosY = (speed * 0.0002) * delta;
            data[1] += newPosY;
        }
        if (moveFaster && !moveSlower) {
            speed /= 4f;
        }
        if (moveSlower && !moveFaster) {
            speed *= 10f;
        }
	}

	@Override
	public Renderable draw() 
	{
		return new PlayerGL(this);
	}
}
