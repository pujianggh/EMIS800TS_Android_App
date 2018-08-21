package cn.signature.tool.view.point;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class DrawPoint {
    public float x;
    public float y;
    public float width;

    public DrawPoint set(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
        return this;
    }
}
