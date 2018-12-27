package Engine.Entities;

public abstract class Component {

    protected Entity parent;

    public Component(Entity parentEntity){
        this.parent = parentEntity;
    }
    public abstract void update();
}
