package DesignPatterns.State;

/**
 * Объект меняет свое поведение в зависимости от
 * своего состояния и позволяет избежать множественного If
 * В context делается выборка ,какой из state использовать
 * Разница между State и Strategy
 *В Strategy все варианты выбора используются
 * для одной цели(сортировки например) и мы управляем поведением объекта
 * В State состояния меняются внутри состояний(прямо в методе смены состояния,если это требуется офк)
 * либо внутри context а в стратегия меняется напрямую main классом либо клиентом
 * Пример стратегия яндекс карт - гибрид, схема,спутник
 * состояние - панорама улиц либо вид сверху(схема)
 */
public class MainTest {
    public static void main(String[] args) {

        TransformerContext context = new TransformerContext();
        TransformerState move = new MoveState();
        TransformerState fire = new FireState();
        context.setState(fire);
        context.doAction();
        context.setState(move);
        context.doAction();
    }
}
