package com.emisoft.sistemtrailerscrudsprintboot.Exceptions;

public class StoreExceptions extends RuntimeException
{
    private  static final long serialVersionUID = 1L;

    public StoreExceptions(String message)
    {
        super(message);
    }

    public StoreExceptions(String message, Throwable exception)
    {
        super(message, exception);
    }
}
