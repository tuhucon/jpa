package com.example.jpa.workflow;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateFactory {
    private static Map<Integer, State> stateMap;
    private static Map<Integer, Class<?>> classMap;
    public static State getState(Integer stateType) {
        if (stateMap == null) {
            stateMap = new HashMap<>();
            classMap = new HashMap<>();
            Reflections reflections = new Reflections("com.example");
            Set<Class<?>> stateClasses = reflections.getTypesAnnotatedWith(StateType.class);
            stateClasses.forEach(clazz -> {
                Integer type = clazz.getAnnotation(StateType.class).type();
                State state = (State) createNewInstanceOfClass(clazz);
                stateMap.put(type, state);
                classMap.put(type, clazz);
            });
        }
        return stateMap.get(stateType);
    }

    public static State getNewStateFromDestination(State desState) {
        if (classMap == null) {
            classMap = new HashMap<>();
            Reflections reflections = new Reflections("com.example");
            Set<Class<?>> stateClasses = reflections.getTypesAnnotatedWith(StateType.class);
            stateClasses.forEach(clazz -> {
                Integer type = clazz.getAnnotation(StateType.class).type();
                classMap.put(type, clazz);
            });
        }
        State state = (State) createNewInstanceOfClass(classMap.get(desState.getType()));
        //copy property from distination state to new state
        state.setState(desState.state);
        state.setType(desState.type);
        return state;
    }

    private static<T> T createNewInstanceOfClass(Class<T> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }
}
