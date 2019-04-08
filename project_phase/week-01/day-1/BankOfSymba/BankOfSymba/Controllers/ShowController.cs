﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankOfSymba.Models;
using Microsoft.AspNetCore.Mvc;


namespace BankOfSymba.Controllers
{
    [Route("")]
    public class ShowController : Controller
    {
        [HttpGet("show")]
        public IActionResult Account()
        {
            BankAccount bankAccout = new BankAccount("Symba", 10000, "Lion");

            return View(bankAccout);
        }

        [HttpGet("escape")]

        public IActionResult Escaped()
        {
            return View();
        }

        [HttpGet("accounts")]
        public IActionResult Accounts()
        {
            AccountsShowViewModel accounts = new AccountsShowViewModel();

            return View(accounts);
        }
    }
}