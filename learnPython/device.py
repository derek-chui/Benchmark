from abc import ABC, abstractmethod
#import learnPython

class Item(ABC):

    @abstractmethod
    
    def use(self):
        pass

class Device():

    isDevice = True

    def __init__(self, brand):
        self.brand = brand

    def lock(self):
        print("This "+self.brand+" device is locked")
        return self

    def charge(self):
        print("This "+self.brand+" device is charging")
        return self

class Mobile:

    isMobile = True

    def __init__(self, brand):
        super().__init__(brand)


class Phone(Device, Mobile):
    pass

# print(__name__)
# print(learnPython.__name__)