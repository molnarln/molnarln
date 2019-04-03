﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Valami
{
    class Animal
    {
        protected int hunger;
        protected int thirst;

        public int Hunger
        {
            get { return this.hunger; }
        }

        public int Thirst
        {
            get { return this.thirst; }
        }


        public Animal()
        {
            this.hunger = 50;
            this.thirst = 50;
        }

        public void Eat()
        {
            this.hunger--;
        }

        public void Drink()
        {
            this.thirst--;
        }

        public void Play()
        {
            this.hunger++;
            this.thirst++;
        }

    }
}
