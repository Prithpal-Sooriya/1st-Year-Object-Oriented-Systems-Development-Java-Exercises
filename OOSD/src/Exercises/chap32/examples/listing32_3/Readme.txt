Event Dispatcher

When dealing with GUI elements, It is not a good idea to always use threads (because it is not thread safe)

However if you do want to use threads, use a Event Dispatcher --> dispatch threads at same time to avoid conflict

    --> put code in Runnable (run method)

InvokeLater --> returns immediately, without waiting for the event dispatch thread to execute the code
InvokeAndWait --> like invokeLater, except doesnt return until the event dispatch thread has executed specified code

E.G. use:
    If GUI doesnt start up first, use:
        SwingUtilities.invokeLater(new Runnable{run(...)})
    Invoke later will allow the SwingUtilities to be ran first before other code is executed
