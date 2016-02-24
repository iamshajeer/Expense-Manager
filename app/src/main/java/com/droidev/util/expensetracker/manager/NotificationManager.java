package com.droidev.util.expensetracker.manager;

import android.app.Notification;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by shajeer on 24/2/16.
 */
public class NotificationManager {

    private static NotificationManager sNotifier;
    private final HashMap<Notification, ArrayList<Observer>> mObservablesMap;

    public interface Observer {
        public void notifyUpdate(Notification notificationName, Bundle data);
    }

    private NotificationManager() {
        mObservablesMap = new HashMap<Notification, ArrayList<Observer>>();
    }


    /**
     * Returns an instance of the {@link NotificationManager}.
     *
     * @return
     */
    public static NotificationManager getInstance() {

        if (sNotifier == null) {
            sNotifier = new NotificationManager();
        }
        return sNotifier;
    }

    /**
     * Registers an Observer for the specified notification.
     *
     * @param notificationName
     * @param observer
     */
    public void addObserver(Notification notificationName, Observer observer) {

        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }

        if (notificationName == null) {
            throw new IllegalArgumentException("The notificationName is null.");
        }

        ArrayList<Observer> observerList = null;
        synchronized (mObservablesMap) {

            if (mObservablesMap.containsKey(notificationName)) {
                observerList = mObservablesMap.get(notificationName);

                if (!observerList.contains(observer))
                    observerList.add(observer);
            } else {
                observerList = new ArrayList<>();

                if (!observerList.contains(observer))
                    observerList.add(observer);
                mObservablesMap.put(notificationName, observerList);
            }
        }
    }

    /**
     * Unregisters the observer from a particular notification.
     *
     * @param notificationName notification to be removed
     * @param observer         observer reference
     */
    public void removeObserver(Notification notificationName, Observer observer) {
        ArrayList<Observer> observerList = null;

        synchronized (mObservablesMap) {

            if (mObservablesMap.containsKey(notificationName)) {
                observerList = mObservablesMap.get(notificationName);

                //Remove the observer
                if (observerList.contains(observer))
                    observerList.remove(observer);

				/* Remove the key mapping if there are no other observers for the
                particular notification */
                if (observerList.isEmpty())
                    mObservablesMap.remove(notificationName);
            }
        }
    }

    /**
     * Removes a particular observer from all the notifications.
     * Ideally used for cleanup when an Observer closes or goes out of scope.
     *
     * @param observer observer reference
     */
    public void removeObserver(Observer observer) {

        synchronized (mObservablesMap) {
            Set<Notification> keys = mObservablesMap.keySet();

            for (Notification key : keys) {
                ArrayList<Observer> observers = mObservablesMap.get(key);

                if (observers.contains(observer))
                    observers.remove(observer);
            }
        }
    }

    /**
     * Notifies all the observers on occurance of an event.
     * Optional data can also be sent.
     *
     * @param notificationName
     * @param data
     */
    public void notifyObservers(Notification notificationName, Bundle data) {
        int size = 0;
        Observer[] observersToNotify = null;

        synchronized (mObservablesMap) {

            if (mObservablesMap.containsKey(notificationName)) {
                ArrayList<Observer> observers = mObservablesMap.get(notificationName);
                size = observers.size();
                observersToNotify = new Observer[size];
                observers.toArray(observersToNotify);
            }
        }

        //Notify all observers
        if (observersToNotify != null) {

            for (int i = 0; i < observersToNotify.length; i++) {
                observersToNotify[i].notifyUpdate(notificationName, data);
            }
        }
    }
}
