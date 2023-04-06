import pyautogui
import time

latInicial = -22.0647
longInicial = -43.4543

latFinal = -22.4186
longFinal = -43.4613

input1 = (1581, 265)
input2 = (1565, 379)
input3 = (1546, 497)
input4 = (1531, 628)

input5 = (1528, 250)
input6 = (1533, 381)
input7 = (1531, 503)
input8   = (1537, 626)
proximo = (1631, 691)
print(pyautogui.position())

pyautogui.click(input1)
pyautogui.write(str(latInicial))
pyautogui.click(input2)
pyautogui.write(str(longInicial))
pyautogui.click(input3)
pyautogui.write(str(latFinal))
pyautogui.click(input4)
pyautogui.write(str(longFinal))

pyautogui.click(proximo)

time.sleep(1)

pyautogui.click(input5)
pyautogui.write(str(latInicial))
pyautogui.click(input6)
pyautogui.write(str(longInicial))
pyautogui.click(input7)
pyautogui.write(str(latFinal))
pyautogui.click(input8)
pyautogui.write(str(longFinal))